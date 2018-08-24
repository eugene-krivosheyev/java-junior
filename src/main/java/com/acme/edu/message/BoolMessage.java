package com.acme.edu.message;

public class BoolMessage implements Message {
    private boolean message;

    public BoolMessage (boolean message) {
        this.message = message;
    }
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return "primitive" + ": " + message + System.lineSeparator();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
