package com.acme.edu.model.message;

public abstract class UnableToJoinMessageWithStringValue extends MessageWithStringValue {

    public UnableToJoinMessageWithStringValue(String value) {
        super(value);
    }

    public Message getJoinedMessage(Message message) {
        throw new IllegalStateException();
    }

    public boolean canJoinMessage(Message message) {
        return false;
    }
}
