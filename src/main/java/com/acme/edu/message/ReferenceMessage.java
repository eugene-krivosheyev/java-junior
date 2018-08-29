package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.Map;

public class ReferenceMessage extends Message {
    private Object message;

    public Object getMessage() {
        return message;
    }

    public ReferenceMessage(Object message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.REFERENCE));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
