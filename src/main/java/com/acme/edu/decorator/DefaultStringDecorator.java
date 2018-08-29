package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;

import java.util.Map;

public class DefaultStringDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        String text = ((StringMessage)message).getMessage();
        int countOfStrings = ((StringMessage)message).getCountOfStrings();
        return "string: " + text + (countOfStrings > 1 ? " (x" + countOfStrings + ')' : "");
    }

    @Override
    public void update(Map<MessageType, Decorator> decoratorMap) {
        decoratorMap.put(MessageType.STRING, this);
    }
}
