package com.acme.edu.message.decorator;

import com.acme.edu.MessageType;
import com.acme.edu.message.CharMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class DefaultCharDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "char: " + ((CharMessage)message).getMessage();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.CHAR, this);
    }
}
