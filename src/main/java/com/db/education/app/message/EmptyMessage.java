package com.db.education.app.message;

public class EmptyMessage implements Message {

    private static final String TYPE = "EMPTY MESSAGE";

    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean isEmptyMessage() {
        return true;
    }

    @Override
    public boolean needsFlush() {
        return false;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public String toString() {
        return this.TYPE;
    }
}
