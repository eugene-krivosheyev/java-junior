package com.acme.edu.api.message;

public class StringMessage extends Message {
    private int currentStringCounter;
    private String current;
    public StringMessage(String value) {
        setPrefix("string: ");
        current = value;
        setValue(value);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public Message accumulate(Message message) {
        StringMessage stringMessage = (StringMessage) message;
        if (stringMessage.getValue().equals(getValue())) {

        }
        return message;
    }
}
