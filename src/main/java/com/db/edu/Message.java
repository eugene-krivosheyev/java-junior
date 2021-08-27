package com.db.edu;

abstract public class Message {
    protected States state;
    public abstract String getDecoratedMessage();

    public abstract Message accumulate(Message message);

    public States getState() {
        return state;
    }

    public abstract boolean isSameType(Message message);
}