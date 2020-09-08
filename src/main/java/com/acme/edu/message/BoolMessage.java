package com.acme.edu.message;

public class BoolMessage implements Message {

    private boolean message;

    private final String prefix = "primitive: ";

    public BoolMessage(boolean message){
        this.message = message;
    }

    @Override
    public String toString() {
        return prefix + message;
    }
}
