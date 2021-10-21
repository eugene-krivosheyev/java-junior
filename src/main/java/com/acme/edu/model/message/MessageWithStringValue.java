package com.acme.edu.model.message;

public abstract class MessageWithStringValue implements Message {
    private final String stringValue;

    public MessageWithStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public abstract Message getJoinedMessage(Message message);

    public abstract boolean canJoinMessage(Message message);

    public String getStringValue() {
        return stringValue;
    }
}
