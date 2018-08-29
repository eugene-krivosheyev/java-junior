package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class DefaultIntDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "primitive: " + ((IntMessage)message).getMessage();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.INT, this);
    }
}
