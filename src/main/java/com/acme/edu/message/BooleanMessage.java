package com.acme.edu.message;

public class BooleanMessage extends Message {
    private static final String TYPE_NAME = "primitive";
    private boolean value;

    public BooleanMessage(boolean message) {
        this.value = message;
        type = TYPE_NAME;
    }


    @Override
    public Message accumulate(Message message) {
        return message;
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
