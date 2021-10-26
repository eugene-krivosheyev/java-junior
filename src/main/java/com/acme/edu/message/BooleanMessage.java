package com.acme.edu.message;

public class BooleanMessage extends Message {

    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }

    @Override
    public void process(Message message) {
        System.out.println("Unreachable output ...");
    }

    @Override
    public String decorate() {
        return "primitive: " + value;
    }
}
