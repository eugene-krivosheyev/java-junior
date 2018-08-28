package com.acme.edu.message.decorator;

import com.acme.edu.MessageType;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class BinaryIntDecorator extends DefaultIntDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return Integer.toBinaryString(((IntMessage)message).getMessage());
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        super.update(decoratorMap);
    }
}