package com.acme.edu.decorator;

import com.acme.edu.message.MessageType;
import com.acme.edu.message.Message;

import java.util.Map;

public interface Decorator {
    String decorate(Message message);

    void update(Map<MessageType, Decorator> decoratorMap);
}
