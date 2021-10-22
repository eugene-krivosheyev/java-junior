package com.acme.edu.model.message;

public class ObjectMessage extends UnableToJoinMessage {
    private final Object value;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "reference: " + value.toString();
    }

    @Override
    public Object getValue() {
        return value;
    }
}
