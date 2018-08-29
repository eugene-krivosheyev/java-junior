package com.acme.edu.decorator;

import com.acme.edu.message.Message;
import com.acme.edu.message.ReferenceMessage;

public class DefaultReferenceDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "reference: " + ((ReferenceMessage)message).getMessage();
    }

}
