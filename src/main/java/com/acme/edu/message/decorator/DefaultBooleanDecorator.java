package com.acme.edu.message.decorator;

import com.acme.edu.message.BooleanMessage;
import com.acme.edu.message.Message;

public class DefaultBooleanDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "primitive: " + ((BooleanMessage)message).getMessage();
    }
}
