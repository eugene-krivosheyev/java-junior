package com.db.education.app.message;

public class EmptyMessage implements Message{
    private final MessageType type = MessageType.EMPTY;

    @Override
    public boolean accumulate(Message message) { return true; }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }
}
