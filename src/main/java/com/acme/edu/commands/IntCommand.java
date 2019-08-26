package com.acme.edu.commands;

public class IntCommand implements PrimitiveCommand {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public IntCommand accumulate(Command other) {
        message += ((IntCommand) other).message;
        return this;
    }
}
