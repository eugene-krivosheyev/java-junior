package com.acme.edu;

public class CharMessage implements Message {
    private char value;

    public CharMessage(char message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return "char: " + value;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }
}
