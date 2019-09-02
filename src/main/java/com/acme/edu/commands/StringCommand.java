package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

import java.util.Objects;

public class StringCommand implements Command, AccumulableCommand {
    public static final String STRING_PREFIX = "string: ";

    private int counter = 1;
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    private StringCommand(String message, int counter) {
        this.message = message;
        this.counter = counter;
    }

    @Override
    public String getDecorated() {
        String result = STRING_PREFIX + message;
        if (counter > 1) {
            result += " (x" + counter + ")";
        }
        return result;
    }

    @Override
    public StringCommand accumulate(Command other, Saver saver) {
        if (!(other instanceof StringCommand)) {
            throw new IllegalArgumentException("Can't accumulate StringCommand with other Command subclass");
        }

        String otherMessage = ((StringCommand) other).getMessage();

        if (Objects.equals(message, otherMessage)) {
            return getIncrementedCopy();
        } else {
            return flushPreviousStringAndGetNew(otherMessage, saver);
        }
    }

    private String getMessage() {
        return message;
    }

    private StringCommand getIncrementedCopy() {
        return new StringCommand(this.message, this.counter + 1);
    }

    private StringCommand flushPreviousStringAndGetNew(String newMessage, Saver saver) {
        saver.save(getDecorated());
        return new StringCommand(newMessage, 1);
    }
}
