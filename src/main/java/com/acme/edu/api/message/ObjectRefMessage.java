package com.acme.edu.api.message;

public class ObjectRefMessage extends Message {
    public ObjectRefMessage(Object value) throws NullMessageException {
            if (value == null) {
                throw new NullMessageException("You try to write a Null Object");
            }
            setPrefix("reference: ");
            setValue(value.toString());
        }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof ObjectRefMessage;
    }
}
