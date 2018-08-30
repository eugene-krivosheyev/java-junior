package com.acme.edu.message;

import com.acme.edu.DecorateException;

public class CharMessage implements Message {
    private final String PREFIX = "char";
    private final String SEPARATOR = ": ";

    private char rawMessage;
    private String decoratedMessage;

    public CharMessage(char rawMessage) {
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
        return message instanceof CharMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }
}
