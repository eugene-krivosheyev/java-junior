package com.acme.edu.message;

import com.acme.edu.MessageType;
import com.acme.edu.message.decorator.Decorator;

import java.util.Map;

public class CharMessage extends Message {
    private char message;

    public char getMessage() {
        return message;
    }

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.CHAR));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
