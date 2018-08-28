package com.acme.edu.message;

public class ReferenceMessage extends Message {
    private Object message;

    public Object getMessage() {
        return message;
    }

    public ReferenceMessage(Object message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
