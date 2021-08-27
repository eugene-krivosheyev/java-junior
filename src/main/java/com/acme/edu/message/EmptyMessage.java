package com.acme.edu.message;

public class EmptyMessage extends Message {

    public EmptyMessage() {
        super(null);
    }

    @Override
    public boolean sameTypeOf(Message message) {
        return false;
    }

    @Override
    public Message accumulate(Message message) {

        return this;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}
