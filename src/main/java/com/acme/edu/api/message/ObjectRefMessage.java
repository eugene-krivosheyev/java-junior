package com.acme.edu.api.message;

public class ObjectRefMessage extends Message {
    public ObjectRefMessage(Object value) throws NullPointerException {
        if (value == null) throw new NullPointerException("You try to write a Null Object");
        setPrefix("reference: ");
        setValue(value.toString());
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof ObjectRefMessage;
    }
}
