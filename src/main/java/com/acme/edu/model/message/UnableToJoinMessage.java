package com.acme.edu.model.message;

public abstract class UnableToJoinMessage implements Message {

    public Message getJoinedMessage(Message message) {
        throw new IllegalStateException();
    }

    public boolean canJoinMessage(Message message) {
        return false;
    }
}
