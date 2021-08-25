package com.acme.edu.messages;

public class StringMessage extends Message {
    private String value;

    public StringMessage(String message) {
        super(message);
        this.value = message;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String wrapMessage() {
        return this.message_type + ": " + this.value;
    }
}
