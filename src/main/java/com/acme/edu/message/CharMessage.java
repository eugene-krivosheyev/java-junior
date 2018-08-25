package com.acme.edu.message;

public class CharMessage implements Message {
    private char message;
    private static final String CHAR = "char: ";

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return CHAR + this.message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }
}
