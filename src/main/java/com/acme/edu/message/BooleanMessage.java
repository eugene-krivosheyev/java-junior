package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.Map;

public class BooleanMessage extends Message {
    private boolean message;

    public boolean getMessage() {
        return message;
    }

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.BOOLEAN));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
