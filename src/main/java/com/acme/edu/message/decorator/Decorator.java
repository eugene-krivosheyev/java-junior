package com.acme.edu.message.decorator;

import com.acme.edu.MessageType;
import com.acme.edu.message.Message;

import java.util.Map;

public interface Decorator {
    String decorate(Message message);

    //MessageType getMessageType();

    void update(Map<MessageType, Decorator> decoratorMap);
}
