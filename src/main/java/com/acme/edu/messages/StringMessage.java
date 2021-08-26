package com.acme.edu.messages;

public class StringMessage extends Message {
    public StringMessage(String message) {
        super(message);
        this.value = message;
    }
}
