package com.db.edu.message;


public abstract class Message {
    private final Object message;

    public Message(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public abstract Message accumulate(Message message);

    public abstract String decorate();

    public abstract boolean sameTypeOf(Message accumulateMessage);
}
