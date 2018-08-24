package com.acme.edu;

public class ByteMessage implements Message {
    private byte value;

    public ByteMessage(byte message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + value;
    }

    @Override
    public Message accumulate(Message message) {
        return new ByteMessage ((byte)(value + ((ByteMessage)message).value));
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }
}
