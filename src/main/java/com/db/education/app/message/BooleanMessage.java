package com.db.education.app.message;

public class BooleanMessage implements Message {
    private final MessageType type = MessageType.BOOL;
    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String toString() {
        return "primitive: " + value + System.lineSeparator();
    }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }
}
