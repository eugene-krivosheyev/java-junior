package com.acme.edu.model.message;

public class StringMessageWithConcatenation extends MessageWithStringValue {
    public StringMessageWithConcatenation(String stringValue) {
        super(stringValue);
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!canJoinMessage(message)) throw new IllegalStateException();

        return new StringMessageWithConcatenation(getStringValue()
                + System.lineSeparator()
                + ((StringMessageWithConcatenation) message).getStringValue());
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return message instanceof StringMessageWithConcatenation;
    }

    @Override
    public String toString() {
        return getStringValue();
    }
}
