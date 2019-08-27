package com.acme.edu.commands;

import java.util.Objects;

public class StringCommand implements Command {
    private String message;
    private int counter;

    public StringCommand(String message, int counter) {
        this.message = message;
        this.counter = counter;
    }

    public StringCommand(String message) {
        this(message, 1);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        if (counter != 1) {
            message += " (x" + counter + ")";
            counter = 1;
        }
        return message;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return (command instanceof StringCommand) &&
                (Objects.equals(this.message, ((StringCommand) command).getMessage()));
    }

    @Override
    public StringCommand accumulate(Command command) {
        int newCounter = counter + ((StringCommand) command).getCounter();
        return new StringCommand(this.message, newCounter);
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return false;
    }
}
