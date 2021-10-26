package com.acme.edu.message;

public class BooleanMessage extends Message {

    private boolean value;

    public boolean isValue() {
        return value;
    }

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }

    @Override
    public void process(Message message) {

    }

    @Override
    public String decorate() {
        return null;
    }
}
