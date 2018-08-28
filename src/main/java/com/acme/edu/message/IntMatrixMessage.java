package com.acme.edu.message;

import com.acme.edu.MessageType;
import com.acme.edu.message.decorator.Decorator;

import java.util.Map;

public class IntMatrixMessage extends Message {
    int[][] message;

    public int[][] getMessage() {
        return message;
    }

    public IntMatrixMessage(int[][] message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.INTMATRIX));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
