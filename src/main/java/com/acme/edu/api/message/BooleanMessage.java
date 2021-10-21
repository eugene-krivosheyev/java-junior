package com.acme.edu.api.message;

public class BooleanMessage extends Message {
    public BooleanMessage(boolean value) {
        setPrefix("primitive: ");
        setValue(String.valueOf(value));
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof BooleanMessage;
    }
}
