package com.acme.edu;

public class StringCommand implements Command {
    private final String message;

    public StringCommand(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return null;
    }
}
