package com.acme.edu.message;

public abstract class Message {

    public abstract boolean isSameType(Message message);

    public abstract void process(Message message);

    public abstract String decorate();
}
