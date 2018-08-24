package com.acme.edu.message;

public class ObjectMessage extends Message {
    private static final String TYPE_NAME = "reference";
    private Object value;

    public ObjectMessage(Object message) {
        this.value = message;
        type = TYPE_NAME;
    }

    @Override
    public String getFormattedMessage() {
        return super.getFormattedString(String.valueOf(value));
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return false;
    }
}
