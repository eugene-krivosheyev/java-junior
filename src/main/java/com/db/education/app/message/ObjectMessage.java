package com.db.education.app.message;

public class ObjectMessage implements Message {
    private Object value;
    private final MessageType type = MessageType.OBJECT;

    public ObjectMessage(Object value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String toString() {
        return "reference: " + value + System.lineSeparator();
    }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }

    @Override
    public Object getValue() {
        return value;
    }
}
