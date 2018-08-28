package com.acme.edu.message;

import com.acme.edu.MessageType;
import com.acme.edu.message.decorator.Decorator;

import java.util.Map;

abstract public class Message {
    abstract public Message accumulate(Message message);

    public String decorate(Decorator decorator) {
        return decorator.decorate(this);
    }

    abstract public String decorate(Map<MessageType, Decorator> decoratorMap);

    abstract public boolean isAbleToAccumulate(Message message);
}
