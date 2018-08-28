package com.acme.edu.message;

public class BooleanMessage implements Message {
    private final String PREFIX = "primitive";
    private final String SEPARATOR = ": ";

    private boolean rawMessage;
    private String decoratedMessage;

    public BooleanMessage(boolean rawMessage) {
        this.rawMessage = rawMessage;
        this.decoratedMessage = String.valueOf(rawMessage);
    }

    @Override
    public Message accumulate(Message message) {
        return this;
    }

    @Override
    public Message decorate() {
        this.decoratedMessage = PREFIX + SEPARATOR + String.valueOf(rawMessage);
        return this;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }
}
