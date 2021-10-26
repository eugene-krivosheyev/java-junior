package com.acme.edu.model.message;

import com.acme.edu.model.exception.LoggerException;

public class IntMessage implements Message {
    private final int value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public Message getAccumulatedMessage(Message message) throws LoggerException {
        if (!canAccumulateMessage(message)) {
            throw new LoggerException("Unable to accumulate messages", new IllegalStateException());
        }
        return new IntMessage(value + ((IntMessage) message).getBody());
    }

    @Override
    public String toString() {
        return "primitive: " + value;
    }

    @Override
    public boolean canAccumulateMessage(Message message) {
        if (message instanceof IntMessage) {
            return (long) value + ((IntMessage) message).value < Integer.MAX_VALUE;
        }
        return false;
    }

    @Override
    public Integer getBody() {
        return value;
    }
}
