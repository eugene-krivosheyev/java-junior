package com.acme.edu.message;

public class BooleanMessage implements Message {

    protected static final String BOOLEAN_PREFIX = "primitive: ";

    private final boolean accumulator;

    public BooleanMessage(boolean bool) {
        this.accumulator = bool;
    }

    @Override
    public Message[] append(Message message) {
        return new Message[]{ message };
    }

    @Override
    public String getBody() {
        return BOOLEAN_PREFIX + accumulator;
    }

    @Override
    public boolean canAppend(Message message) {
        return false;
    }
}
