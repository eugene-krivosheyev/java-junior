package com.acme.edu.message.decorator;

import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.Message;

public class DefaultByteDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "primitive: " + ((ByteMessage)message).getMessage();
    }
}
