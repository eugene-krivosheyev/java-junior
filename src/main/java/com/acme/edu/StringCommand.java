package com.acme.edu;

public class StringCommand implements Command {
    private final static String STRING_PREFIX = "string: ";
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public Command accumulate(Command other) {
        return null;
    }

    @Override
    public String getDecorated() {
        return STRING_PREFIX + this.message;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof StringCommand;
    }

    @Override
    public boolean isOverflow() {
        return false;
    }
}
