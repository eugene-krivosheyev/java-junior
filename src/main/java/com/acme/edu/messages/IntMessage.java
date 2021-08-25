package com.acme.edu.messages;

public class IntMessage extends Message {
    private int value;

    public IntMessage(int message) {
        super(message);
        this.value = message;
    }

    @Override
    public String wrapMessage() {
        return this.message_type + ": " + this.value;
    }
}
