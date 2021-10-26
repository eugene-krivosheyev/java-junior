package com.acme.edu.model.message;

public class NullMessage implements Message {
    @Override
    public Message getJoinedMessage(Message message) {
        return message;
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return true;
    }

    @Override
    public Object getValue() {
        throw new IllegalStateException();
    }
}
