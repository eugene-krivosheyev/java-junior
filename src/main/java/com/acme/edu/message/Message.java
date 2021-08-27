package com.acme.edu.message;

public abstract class Message {
    private final Object body;

    public Message(Object body) {
        this.body = body;
    }

    public Object getBody() {
        return this.body;
    }

    public abstract boolean sameTypeOf(Message message);

    public abstract Message accumulate(Message message);

    public abstract String getDecoratedMessage();
}
