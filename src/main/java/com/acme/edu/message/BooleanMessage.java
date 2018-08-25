package com.acme.edu.message;

public class BooleanMessage implements Message{
    private boolean message;
    private static final String PRIMITIVE = "primitive: ";

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return false;
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE + this.message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }
}
