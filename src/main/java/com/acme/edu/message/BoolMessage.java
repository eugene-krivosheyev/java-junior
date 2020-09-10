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

    @Override
    public boolean isSameType(Message message) {
        return message instanceof BoolMessage;
    }

    @Override
    public void updateAccumulator(Message message) {
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public boolean needFlush(Message message) {
        return false;
    }
}
