package com.acme.edu.message;

public class CharMessage extends Message {
    private static final String TYPE_NAME = "char";
    private char value;

    public CharMessage(char message) {
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
