package com.acme.edu.ooad.message;

public class NumericMessage extends ObjectMessage{

    private final int value;

    protected int getValue() {
        return value;
    }

    public NumericMessage(int value) {
        super("primitive: ");
        this.value = value;
    }

    @Override
    public String toString() {
        return getPrefix() + value;
    }
}
