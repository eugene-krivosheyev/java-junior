package com.acme.edu.commands.types;

import com.acme.edu.buffer.BufferState;
import com.acme.edu.commands.Command;
import com.acme.edu.saver.ConsoleSaver;

public class StringCommand implements Command<String> {
    private String message;
    private int counterOfStrings = 1;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return "string: " + message;
    }

    @Override
    public Command<String> accumulate(Command command) {
        if(command.getMessage().equals(message)) {
            counterOfStrings++;
        }
        else {
            if (message != null) {
                if (counterOfStrings > 1) { new ConsoleSaver().saveWithoutPrefix(new StringCommand(message + " (x" + counterOfStrings + ")"));
                } else { new ConsoleSaver().saveWithoutPrefix(new StringCommand(message)); }
            }
            counterOfStrings = 1;
            message = (String) command.getMessage();
        }
        return this;
    }

    @Override
    public String getMessage() {
        if (counterOfStrings > 1) { message = message + " (x" + counterOfStrings + ")"; }
        return message;
    }

    @Override
    public BufferState getState() { return BufferState.STR; }

}

