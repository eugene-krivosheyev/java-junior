package com.acme.edu.model.message;

public class BooleanMessage extends UnableToJoinMessage {
    private final boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getBody() {
        return value;
    }

    @Override
    public String toString() {
        return "primitive: " + value;
    }

}
