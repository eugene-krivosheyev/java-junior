package com.acme.edu;

public class CharCommand implements Command {
    private final char message;

    public CharCommand(char message) {
        this.message = message;
    }

    public char getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return Constants.CHAR_PREFIX + message;
    }
}
