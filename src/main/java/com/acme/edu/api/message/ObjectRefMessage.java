package com.acme.edu.api.message;

public class ObjectRefMessage extends Message {
    public ObjectRefMessage(String value) {
        setPrefix("reference: ");
        setValue(value);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof ObjectRefMessage;
    }
}
