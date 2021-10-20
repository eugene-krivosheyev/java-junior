package com.acme.edu.messageOut;

public class Formatter {
    private String messagePrefix;

    public String getMessagePrefix() {
        return messagePrefix;
    }
    public void setMessagePrefix(String messagePrefix){
        this.messagePrefix = messagePrefix;
    }

    public String formatMessage(Object message) {
        return messagePrefix + message;
    }
}
