package com.acme.edu.message;

public class CharMessage implements Message {

    protected static final String CHAR_PREFIX = "char: ";

    private final char accumulator;

    public CharMessage(char ch) {
        this.accumulator = ch;
    }

    @Override
    public Message[] append(Message message) {
        return new Message[]{message};
    }

    @Override
    public String getBody() {
        return CHAR_PREFIX + accumulator;
    }

    @Override
    public boolean canAppend(Message message) {
        return false;
    }
}
