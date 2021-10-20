package com.acme.edu.message;

public class BooleanMessage implements Message {

    private boolean value;

    public boolean isValue() {
        return value;
    }

    public BooleanMessage(boolean value) {
        this.value = value;
    }
}
