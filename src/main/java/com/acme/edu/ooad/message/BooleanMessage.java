package com.acme.edu.ooad.message;

public class BooleanMessage extends ObjectMessage {
    private final boolean value;
    
    public BooleanMessage(boolean value) {
        super("primitive: ");
        this.value = value;
    }

    @Override
    public String toString() {
        return getPrefix() + value;
    }
}
