package com.acme.edu.messages;

public class BoolMessage extends Message {
    private boolean value;

    public BoolMessage(boolean message) {
        super(message);
        this.value = message;
    }
    public boolean getValue(){
        return value;
    }

    @Override
    public String wrapMessage() {
        return this.message_type + ": " + this.value;
    }
}
