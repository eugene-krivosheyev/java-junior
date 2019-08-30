package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

import java.util.Objects;

/**
 * Created by kate-c on 23/08/2019.
 */
public class StringCommand extends Command {
    private String message;
    private int stringCounter;

    public StringCommand(String message) {
        this.message = message;
        this.stringCounter = 1;
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


    @Override
    public Command accumulate(Command command, Saver saver) {
        if (command == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (!(command instanceof StringCommand)) {
            throw new IllegalArgumentException("Not the same type of message");
        }
        String newMessage = ((StringCommand) command).getMessage();
        if (!this.isTypeEqual(command)) {
            this.flush(saver);
            return new StringCommand(newMessage, 1);
        }
        return new StringCommand(message, stringCounter + 1);
    }
}
