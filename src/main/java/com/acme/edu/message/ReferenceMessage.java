package com.acme.edu.message;

public class ReferenceMessage implements Message {

    private static final String REFERENCE_PREFIX = "reference: ";

    private Object accumulator;

    public ReferenceMessage(Object reference) {
        this.accumulator = reference;
    }

    @Override
    public Message append(Message message) {
        return this;
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
