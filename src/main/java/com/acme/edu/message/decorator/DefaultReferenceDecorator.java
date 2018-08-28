package com.acme.edu.message.decorator;

import com.acme.edu.MessageType;
import com.acme.edu.message.Message;
import com.acme.edu.message.ReferenceMessage;

import java.util.Map;

public class DefaultReferenceDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "reference: " + ((ReferenceMessage)message).getMessage();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.REFERENCE, this);
    }
}
