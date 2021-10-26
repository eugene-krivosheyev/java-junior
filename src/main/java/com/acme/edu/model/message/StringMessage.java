package com.acme.edu.model.message;

import com.acme.edu.model.exception.LoggerException;

public class StringMessage implements Message {
    private final String value;
    private final int numOfRepeats;

    private StringMessage(String value, int numOfRepeats) {
        this.value = value;
        this.numOfRepeats = numOfRepeats;
    }

    public StringMessage(String value) {
        this(value, 1);
    }

    @Override
    public String toString() {
        String postfix = (numOfRepeats > 1) ? " (x" + numOfRepeats + ")" : "";
        return "string: " + value + postfix;
    }

    @Override
    public Message getAccumulatedMessage(Message message) throws LoggerException {
        if (!canAccumulateMessage(message)) {
            throw new LoggerException("Unable to accumulate messages", new IllegalStateException());
        }

        return new StringMessage(value, numOfRepeats + 1);
    }

    @Override
    public boolean canAccumulateMessage(Message message) {
        return message instanceof StringMessage
                && ((StringMessage) message).getBody().equals(value);
    }

    @Override
    public String getBody() {
        return value;
    }

}