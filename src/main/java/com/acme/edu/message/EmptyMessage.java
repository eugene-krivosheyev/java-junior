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
    public void accumulate(Message message) {

    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}
