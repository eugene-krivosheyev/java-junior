package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
import com.acme.edu.message.BooleanMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class DefaultBooleanDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "primitive: " + ((BooleanMessage)message).getMessage();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.BOOLEAN, this);
    }
}
