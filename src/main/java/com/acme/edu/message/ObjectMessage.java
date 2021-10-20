package com.acme.edu.message;

public class ObjectMessage implements Message {

    private Object value;

    public Object getValue() {
        return value;
    }

    public ObjectMessage(Object value) {
        this.value = value;
    }
}
