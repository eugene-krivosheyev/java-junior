package com.acme.edu.message.decorator;

import com.acme.edu.message.Message;
import com.acme.edu.message.ReferenceMessage;

public class DefaultReferenceDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "reference: " + ((ReferenceMessage)message).getMessage();
    }
}
