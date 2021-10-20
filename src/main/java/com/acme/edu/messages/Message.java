package com.acme.edu.messages;

public abstract class Message {
    String prefix;
    String value;

    public String getMessageAsString() {
        return prefix + value;
    }
}