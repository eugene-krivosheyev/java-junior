package com.acme.edu.messages;

public class CharMessage extends Message {
    private char value;

    public CharMessage(char message) {
        super(message);
        this.value = message;
    }

    public char getValue(){
        return value;
    }

    @Override
    public String wrapMessage() {
        return this.message_type + ": " + this.value;
    }
}
