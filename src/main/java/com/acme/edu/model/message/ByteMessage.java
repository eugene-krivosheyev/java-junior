package com.acme.edu.model.message;


public class ByteMessage implements Message {
    private final byte value;

    public ByteMessage(byte value) {
        this.value = value;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!canJoinMessage(message)) throw new IllegalStateException();
        byte messageValue = ((ByteMessage) message).getValue();
        return new ByteMessage((byte) (value + messageValue));
    }

    @Override
    public String toString() {
        return "primitive: " + getValue();
    }

    @Override
    public boolean canJoinMessage(Message message) {
        if (message instanceof ByteMessage) {
            byte messageValue = ((ByteMessage) message).getValue();
            return (long) value + messageValue < Byte.MAX_VALUE;
        }
        return false;
    }

    @Override
    public Byte getValue() {
        return value;
    }


}
