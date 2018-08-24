package com.acme.edu;

public class BooleanMessage implements Message {
    private boolean value;

    public BooleanMessage(boolean message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + value;
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
