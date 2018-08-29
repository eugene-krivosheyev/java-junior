package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
import com.acme.edu.message.Message;

import java.util.Map;

public class EmptyDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return null;
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.FLUSH, this);
    }
}
