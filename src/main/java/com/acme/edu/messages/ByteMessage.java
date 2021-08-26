package com.acme.edu.messages;

public class ByteMessage extends Message {
    public ByteMessage(byte message) {
        super(message);
        this.value = message;
    }
}
