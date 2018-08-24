package com.acme.edu;

public class ObjectMessage implements Message {
    private Object value;

    public ObjectMessage(Object message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return "reference: " + value;
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
