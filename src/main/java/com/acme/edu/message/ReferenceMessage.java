package com.acme.edu.message;

public class ReferenceMessage implements Message {

    protected static final String REFERENCE_PREFIX = "reference: ";

    private final Object accumulator;

    public ReferenceMessage(Object reference) {
        this.accumulator = reference;
    }

    @Override
    public Message[] append(Message message) {
        return new Message[]{message};
    }

    @Override
    public String getBody() {
        return REFERENCE_PREFIX + accumulator.toString();
    }

    @Override
    public boolean canAppend(Message message) {
        return false;
    }
}
