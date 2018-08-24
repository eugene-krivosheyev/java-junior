package com.acme.edu.message;

public class CharMessage implements Message {
    private char message;

    public char getMessage() {
        return message;
    }

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate() {
        return "char: " + message;
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
