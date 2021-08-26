package com.acme.edu.messages;

public class ObjectMessage extends Message{
    public ObjectMessage(Object message) {
        super(message);
        this.value = message;
    }
}
