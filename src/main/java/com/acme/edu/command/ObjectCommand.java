package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public class ObjectCommand implements Command {
    private Object message = ' ';
    private Saver saver = null;
    private Command prevCommand = null ;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    @Override
    public void accumulate(Command command, Saver saver) throws IOException {
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
    public void flush() throws IOException {
        saver.save(prevCommand.messageDecorate());
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }
}
