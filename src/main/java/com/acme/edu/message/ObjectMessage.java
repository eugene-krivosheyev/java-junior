package com.acme.edu.message;

public class ObjectMessage implements Message {
    private final String PREFIX = "reference";
    private final String SEPARATOR = ": ";

    private Object rawMessage;
    private String decoratedMessage;

    public ObjectMessage(Object rawMessage) {
        this.rawMessage = rawMessage;
        this.decoratedMessage = String.valueOf(rawMessage);
    }

    @Override
    public Message accumulate(Message message) {
        return this;
    }

    @Override
    public Message decorate() {
        this.decoratedMessage = PREFIX + SEPARATOR + rawMessage;
        return this;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }
}
