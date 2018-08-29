package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class DefaultByteDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "primitive: " + ((ByteMessage)message).getMessage();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.BYTE, this);
    }
}
