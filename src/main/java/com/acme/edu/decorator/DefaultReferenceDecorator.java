package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
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
