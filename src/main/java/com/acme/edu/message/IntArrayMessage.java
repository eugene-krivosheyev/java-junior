package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.Map;

public class IntArrayMessage extends Message {
    private int[] message;

    public int[] getMessage() {
        return message;
    }

    public IntArrayMessage(int[] message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.INTARRAY));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
