package com.acme.edu.model.message;

public class StringMessageWithConcatenation implements Message {
    private final String value;

    public StringMessageWithConcatenation(String value) {
        this.value = value;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!canJoinMessage(message)) throw new IllegalStateException();

        return new StringMessageWithConcatenation(value
                + System.lineSeparator()
                + ((StringMessageWithConcatenation) message).getValue());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return message instanceof StringMessageWithConcatenation;
    }

    @Override
    public String toString() {
        return value;
    }
}
