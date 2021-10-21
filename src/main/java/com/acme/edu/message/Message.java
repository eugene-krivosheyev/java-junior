package com.acme.edu.message;

public interface Message {

    public abstract Message append(Message message);

    public abstract String getBody();

    public abstract boolean canAppend(Message message);
}
