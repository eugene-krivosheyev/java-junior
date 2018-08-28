package com.acme.edu.message.decorator;

import com.acme.edu.MessageType;
import com.acme.edu.message.IntArrayMessage;
import com.acme.edu.message.Message;

import java.util.Map;

public class DefaultIntArrayDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        StringBuilder decoratedString = new StringBuilder("primitives array: ");
        decoratedString.append(arrayToString(((IntArrayMessage)message).getMessage()));
        return decoratedString.toString();
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.INTARRAY, this);
    }

    String arrayToString(int[] message) {
        StringBuilder decoratedString = new StringBuilder();
        decoratedString.append("{");
        for (int i = 0; i < message.length - 1; ++i) {
            decoratedString.append(message[i]).append(", ");
        }
        if (message.length > 1) {
            decoratedString.append(message[message.length - 1]);
        }
        decoratedString.append("}");
        return decoratedString.toString();
    }
}
