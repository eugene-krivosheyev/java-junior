package com.acme.edu.message.decorator;

import com.acme.edu.message.Message;

public class EmptyDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return null;
    }
}
