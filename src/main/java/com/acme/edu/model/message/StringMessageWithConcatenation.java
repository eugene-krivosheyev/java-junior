package com.acme.edu.model.message;

import com.acme.edu.model.exception.LoggerException;

public class StringMessageWithConcatenation implements Message {
    private final String value;

    public StringMessageWithConcatenation(String value) {
        this.value = value;
    }

    @Override
    public Message getAccumulatedMessage(Message message) throws LoggerException {
        if (!canAccumulateMessage(message)) {
            throw new LoggerException("Unable to accumulate messages", new IllegalStateException());
        }
        return new StringMessageWithConcatenation(value
                + System.lineSeparator()
                + ((StringMessageWithConcatenation) message).getBody());
    }

    @Override
    public String getBody() {
        return value;
    }

    @Override
    public boolean canAccumulateMessage(Message message) {
        return message instanceof StringMessageWithConcatenation;
    }

    @Override
    public String toString() {
        return value;
    }
}
