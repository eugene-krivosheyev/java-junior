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
        if (other instanceof IntCommand) {
            return new IntCommand(this.message + ((IntCommand) other).getMessage());
        } else {
            throw new IllegalArgumentException("Can't accumulate IntCommand with other Command subclass");
        }
    }

    @Override
    public Integer getMessage() {
        return message;
    }
}
