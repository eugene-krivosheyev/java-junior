package com.db.edu.message;

public class EmptyMessage extends Message {
    public EmptyMessage() {
        super(null);
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate() {
        return null;
    }

    @Override
    public boolean sameTypeOf(Message accumulateMessage) {
        return false;
    }
}
