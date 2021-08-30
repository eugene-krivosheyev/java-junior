package com.acme.edu.message;

import com.acme.edu.Prefix;

public abstract class Message {
    private final Object body;

    public Message(Object body) {
        this.body = body;
    }

    public Object getBody() {
        return this.body;
    }

    public boolean sameTypeOf(Message message){
        return false;
    }

    public Message accumulate(Message message) throws ClassCastException, NullPointerException{
        return this;
    }

    public abstract String getDecoratedMessage();

    protected String getDefaultDecoratedMessage(Prefix prefix){
        return String.format("%s %s%n", prefix.value, body);
    }
}
