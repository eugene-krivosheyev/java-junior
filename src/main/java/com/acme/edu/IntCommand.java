package com.acme.edu;

public class IntCommand implements Command {
    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public boolean isOverflow() {
        return message < 0;
    }

    @Override
    public Command accumulate(Command other) {
        return new IntCommand((int)this.getMessage() + (int)other.getMessage());
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + this.message;
    }

    @Override
    public Object getMessage() {
        return message;
    }
}
