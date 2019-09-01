package com.acme.edu.commands;

public class CharCommand implements Command {
    public static final String CHAR_PREFIX = "char: ";

    private final char message;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return CHAR_PREFIX + message;
    }
}
