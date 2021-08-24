package com.acme.edu.ooad.message;

public class CharMessage extends ObjectMessage {
    
    private final char value;
    
    public CharMessage(char value) {
        super("char: ");
        this.value = value;
    }

    @Override
    public String toString() {
        return getPrefix() + value;
    }
}
