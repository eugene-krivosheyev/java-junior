package com.acme.edu.messages;

public class ByteMessage extends Message {
    private byte value;

    public ByteMessage(byte message) {
        super(message);
        this.value = message;
    }

    @Override
    public String wrapMessage() {
        return this.message_type + ": " + this.value;
    }
}
