package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;

import java.io.IOException;

public class CharCommand implements Command {
    private char message = ' ';
    private ConsoleLoggerSaver saver = null;
    private Command prevCommand = null ;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public void accumulate(Command command, ConsoleLoggerSaver saver) {
        this.saver = saver;
        if (command instanceof NoneCommand) {
            prevCommand = this;
        } else {
            prevCommand = command;
            flush();
        }
    }

    public String messageDecorate() {
        return "char: " + String.valueOf(message);
    }

    @Override
    public void flush() {
        try {
            saver.save(prevCommand.messageDecorate());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }
}
