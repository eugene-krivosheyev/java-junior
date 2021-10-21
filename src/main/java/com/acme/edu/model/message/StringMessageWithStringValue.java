package com.acme.edu.model.message;

public class StringMessageWithStringValue extends MessageWithStringValue {
    private final int numOfRepeats;

    private StringMessageWithStringValue(String value, int numOfRepeats) {
        super(value);
        this.numOfRepeats = numOfRepeats;
    }

    public StringMessageWithStringValue(String value) {
        this(value, 1);
    }

    @Override
    public String toString() {
        String postfix = (numOfRepeats > 1) ? " (x" + numOfRepeats + ")" : "";
        return "string: " + getStringValue() + postfix;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        if (!(message instanceof StringMessageWithStringValue)) throw new IllegalStateException();
        return new StringMessageWithStringValue(getStringValue(), numOfRepeats + 1);
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return message instanceof StringMessageWithStringValue
                && ((StringMessageWithStringValue) message).getStringValue().equals(getStringValue());
    }
}