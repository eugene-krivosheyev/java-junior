package com.acme.edu.mylogger;

public class CharCommand implements Command {
    private final static String CHAR_PREFIX = "char: ";
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public Command accumulate(Command other) {
        return null;
    }

    @Override
    public String getDecorated() {
        return CHAR_PREFIX + this.message;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof CharCommand;
    }

    @Override
    public boolean isOverflow() {
        return false;
    }
}
