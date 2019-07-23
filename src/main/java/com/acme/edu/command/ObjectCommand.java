package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;

public class ObjectCommand implements Command {
    private Object message = ' ';
    private ConsoleLoggerSaver saver = null;
    private Command prevCommand = null ;

    public ObjectCommand(Object message) {
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
        return "reference: " + message.toString();
    }

    @Override
    public void flush() {
        saver.save(prevCommand.messageDecorate());
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }
}
