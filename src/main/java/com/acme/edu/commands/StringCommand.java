package com.acme.edu.commands;

import java.util.Objects;

public class StringCommand implements Command {
    private String message;
    private int counter = 1;

    public StringCommand(String message) {
        this.message = message;
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
                (Objects.equals(this.getMessage(), ((StringCommand) command).getMessage()));
    }

    @Override
    public void accumulate(Command command) {
        counter += ((StringCommand) command).getCounter();
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return false;
    }
}
