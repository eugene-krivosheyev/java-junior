package com.acme.edu.message;

public class ObjectMessage implements Message{
    private Object message;
    private static final String REFERENCE = "reference: ";

    public ObjectMessage(Object message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return REFERENCE + this.message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }
}
