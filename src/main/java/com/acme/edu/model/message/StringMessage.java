package com.acme.edu.model.message;

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
    public Message getJoinedMessage(Message message) {
        if (!(message instanceof StringMessage)) throw new IllegalStateException();
        return new StringMessage(value, numOfRepeats + 1);
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return message instanceof StringMessage
                && ((StringMessage) message).getValue().equals(value);
    }

    @Override
    public String getValue() {
        return value;
    }

}