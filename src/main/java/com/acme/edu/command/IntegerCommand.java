package com.acme.edu.command;

public class IntegerCommand extends CommonCommand<Integer> {
    private int message;

    public IntegerCommand(int message) {
        this.message = message;
    }

    public Integer getMessage() {
        return message;
    }

    @Override
    protected String concreteDecoration(boolean toDecorate) {
        String result = Integer.toString(message);
        if (toDecorate) {
            result = "primitive: " + result;
        }
        return result;
    }

    @Override
    protected String concreteAccumulation(Command previousCommand) {
        message += (int) previousCommand.getMessage();
        return null;
    }
}
