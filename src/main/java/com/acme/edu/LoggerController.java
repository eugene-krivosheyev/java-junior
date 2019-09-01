package com.acme.edu;

import commands.Command;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoggerController {

    private Saver saver;
    private Command notLogged = null;

    private List <Command> commandsBuffer = new ArrayList <>();

    public LoggerController(Saver saver) {
        this.saver = saver;

    }

    public void log(Command command) {

        //guard clause


        if (notLogged == null || notLogged.equalsCommand(command)) {
            commandsBuffer.add(command);
            notLogged = command;
        } else {
            flush();
            notLogged = command;
            commandsBuffer.add(command);
        }
    }


    private Optional <Command> processBuffer() {
        return commandsBuffer.stream()
                .reduce(Command::getAccumulated);
    }

    public void flush() {
        processBuffer().ifPresent(c -> {
                saver.save(c.getDecorated());

        });
        notLogged = null;
        commandsBuffer.clear();
    }
}
