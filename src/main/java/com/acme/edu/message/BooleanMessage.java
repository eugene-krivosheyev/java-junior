package com.acme.edu.message;

import com.acme.edu.exception.DecorateException;

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
    public Message decorate() throws DecorateException {
        try {
            this.decoratedMessage = PREFIX + SEPARATOR + String.valueOf(rawMessage);
        } catch (Exception e) {
            throw new DecorateException(e);
        }
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
