package com.acme.edu;

import java.util.Objects;

/**
 * Created by kate-c on 23/08/2019.
 */
public class StringCommand implements Command {
    private String message;
    private int stringCounter = 1;

    public StringCommand(String message) {
        this.message = message;
    }

    private StringCommand(String message, int stringCounter) {
        this.message = message;
        this.stringCounter = stringCounter;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(Object message) {
        this.message = message.toString();
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return (other instanceof StringCommand) && (Objects.equals(this.message, other.getMessage()));
    }

    @Override
    public String decorate() {
        String temp = "string: " + message;
        if (stringCounter > 1) {
            temp += " (x" + stringCounter + ")";
        }
        return temp;
    }

    //////////////////////

    @Override
    public MayBeFlushableCommand accumulate(Command command) {
        String newMessage = ((StringCommand)command).getMessage();
        if (this.isTypeEqual(command)) {
            stringCounter += 1;
            return new MayBeFlushableCommand(new StringCommand(message, stringCounter), false);
        }
        return new MayBeFlushableCommand(new StringCommand(newMessage, stringCounter), true);
    }

}
