package com.acme.edu.command;

import java.util.Objects;

public class StringCommand extends CommonCommand<String> {
    private String message;
    private int counter;

    public StringCommand(String message) {
        this.message = message;
        this.counter = 1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    protected String concreteDecoration(boolean toDecorate) {
        String result = message;
        if (toDecorate) {
            result = "string: " + result;
        }
        return result;
    }

    @Override
    protected String concreteAccumulation(Command previousCommand) {
        String result = null;
        if (Objects.equals(message, previousCommand.getMessage())) {
            counter += previousCommand.getCounter();
        } else {
            result = previousCommand.flush();
            counter = 1;
        }
        return result;
    }

    @Override
    public String flush() {
        String result = message;
        if (counter > 1) {
            result += " (x" + counter + ")";
        }
        return result;
    }
}
