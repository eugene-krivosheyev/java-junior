package com.acme.edu.model.message;


import com.acme.edu.model.exception.LoggerException;

public class ByteMessage implements Message {
    private final byte value;

    public ByteMessage(byte value) {
        this.value = value;
    }

    @Override
    public Message getAccumulatedMessage(Message message) throws LoggerException {
        if (!canAccumulateMessage(message)) {
            throw new LoggerException("Unable to accumulate messages", new IllegalStateException());
        }

        byte messageValue = ((ByteMessage) message).getBody();
        return new ByteMessage((byte) (value + messageValue));
    }

    @Override
    public String toString() {
        return "primitive: " + getBody();
    }

    @Override
    public boolean canAccumulateMessage(Message message) {
        if (message instanceof ByteMessage) {
            byte messageValue = ((ByteMessage) message).getBody();
            return (long) value + messageValue < Byte.MAX_VALUE;
        }
        return false;
    }

    @Override
    public Byte getBody() {
        return value;
    }


}
