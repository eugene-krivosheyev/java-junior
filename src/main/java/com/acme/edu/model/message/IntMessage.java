package com.acme.edu.model.message;

public class IntMessage implements Message {
    private final int value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!canJoinMessage(message)) throw new IllegalStateException();
        return new IntMessage(value + ((IntMessage) message).getValue());
    }

    @Override
    public String toString() {
        return "primitive: " + value;
    }

    @Override
    public boolean canJoinMessage(Message message) {
        if (message instanceof IntMessage) {
            return (long) value + ((IntMessage) message).value < Integer.MAX_VALUE;
        }
        return false;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
