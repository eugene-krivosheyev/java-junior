package com.acme.edu.message;

public class ReferenceMessage implements  Message {
    private Object message;

    public ReferenceMessage(Object message) {
        this.message = message;
    }
    @Override
    public Message accumulate(Message nextMessage) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return "reference" +": " + message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }
}
