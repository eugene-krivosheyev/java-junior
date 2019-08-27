package com.acme.edu;

import commands.Command;

public class LoggerController {

    private Saver saver;
    private Command notLogged = null;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Command command) {

        if (notLogged == null)
            notLogged = command;
        else if (notLogged.equalsCommand(command))
            notLogged = notLogged.getAccumulated(command);
        else {
            saver.save(notLogged.getDecorated());
            notLogged = command;
        }

    }

    public void flush() {
        saver.save(notLogged.getDecorated());
        notLogged = null;
    }
}
