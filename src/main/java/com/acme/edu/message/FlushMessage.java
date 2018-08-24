package com.acme.edu.message;

public class FlushMessage implements Message {
    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate() {
        return null;
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
