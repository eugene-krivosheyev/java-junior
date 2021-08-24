package com.acme.edu.ooad.message;

public class StringMessage extends ObjectMessage{
    private final String value;
    private final int stringCounter;

    public StringMessage(String value, int stringCounter) {
        super("string: ");
        this.value = value;
        this.stringCounter = stringCounter;
    }

    @Override
    public String toString() {
        return getPrefix() + value + (stringCounter > 1 ? " (x" + stringCounter + ")" : "");
    }
}
