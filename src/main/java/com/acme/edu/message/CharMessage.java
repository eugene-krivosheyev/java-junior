package com.acme.edu.message;

public class CharMessage extends Message {
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
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
