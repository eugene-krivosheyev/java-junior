package com.acme.edu.message.decorator;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

public class DefaultIntDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "primitive: " + ((IntMessage)message).getMessage();
    }
}
