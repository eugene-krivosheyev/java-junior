package com.acme.edu.command;

import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public class BooleanCommand implements Command {
    private boolean message = false;
    private Saver saver = null;
    private Command prevCommand = null ;

    public BooleanCommand(boolean message) {
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
        return String.valueOf("primitive: "+message);
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
