package com.db.education.app.message;

public class EmptyMessage implements Message {
    private final String type = "EMPTY";

    @Override
    public boolean accumulate(Message message) { return true; }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Object getValue() {
        return null;
    }
}
