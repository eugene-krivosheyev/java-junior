package com.acme.edu.message;

public class BooleanMessage extends Message {
    private boolean message;

    public boolean getMessage() {
        return message;
    }

    public BooleanMessage(boolean message) {
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
