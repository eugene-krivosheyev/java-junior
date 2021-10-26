package com.acme.edu.model.message;

public class NullMessage implements Message {
    @Override
    public Message getAccumulatedMessage(Message message) {

        return message;
    }

    @Override
    public boolean canAccumulateMessage(Message message) {
        return true;
    }

    @Override
    public Object getBody() {
        throw new IllegalStateException();
    }
}
