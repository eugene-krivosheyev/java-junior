package com.acme.edu.messages;

public class BoolMessage extends Message {
    public BoolMessage(boolean message) {
        super(message);
        this.value = message;
    }
}
