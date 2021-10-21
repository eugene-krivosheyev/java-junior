package com.acme.edu.printer;

import com.acme.edu.message.DataEqualMessage;

public class MessageDecoratorBasic implements MessageDecorator{

    @Override
    public String decorate(DataEqualMessage message) {
        return message.prefix() + message.getData();
    }
}
