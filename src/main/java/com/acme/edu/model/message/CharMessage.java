package com.acme.edu.model.message;

public class CharMessage extends UnableToJoinMessage {
    private final char value;

    public CharMessage(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "char: " + value;
    }

    @Override
    public Character getValue() {
        return value;
    }
}
