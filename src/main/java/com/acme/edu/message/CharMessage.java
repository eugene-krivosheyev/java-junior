package com.acme.edu.message;

public class CharMessage implements Message {
    private char message;

    public CharMessage(char message) {
        this.message = message;
    }
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return "char" + ": " + message + System.lineSeparator();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
