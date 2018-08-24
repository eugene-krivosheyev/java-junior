package com.acme.edu.message;

public abstract class Message {
    private static final String FORMAT_STRING = "%s: %s";

    protected String type;

    public Message accumulate(Message message){
        return message;
    };

    public abstract String getFormattedMessage();

    public boolean canBeAccumulated(Message message) {
        return message.getClass() == this.getClass();
    }

    protected String getFormattedString(String convertedMessage) {
        return String.format(FORMAT_STRING, type, convertedMessage);
    }
}
