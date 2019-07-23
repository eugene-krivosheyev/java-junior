package com.acme.edu.command;

import com.acme.edu.Type;
import com.acme.edu.saver.ConsoleLoggerSaver;

import java.io.IOException;

public class StringCommand implements Command {
    private String message = "";
    private int count = 1;
    private ConsoleLoggerSaver saver = null;
    private Command prevCommand = null;

    public StringCommand(String message) {
        this.message = message;
    }

    public String messageDecorate() {
        if (count > 1) {
            return message + " (x" + count + ")";
        } else {
            return message;
        }
    }

    @Override
    public void accumulate(Command command, ConsoleLoggerSaver saver)  {
        this.saver = saver;
        if (command instanceof NoneCommand) {
            prevCommand = this;
        } else if (isAccumulative(command)) {
            count = ((StringCommand) command).count + 1;
            prevCommand = this;
        } else {
            prevCommand = command;
            flush();
        }
    }

    private boolean isAccumulative(Command command) {
        if (command instanceof StringCommand) {
            return (message.equals(((StringCommand) command).message));
        } else {
            return false;
        }
    }

    @Override
    public void flush()  {
        try {
            saver.save(prevCommand.messageDecorate());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        };
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }
}
