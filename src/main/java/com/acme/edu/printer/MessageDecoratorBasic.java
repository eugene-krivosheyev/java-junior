package com.acme.edu.printer;

import com.acme.edu.message.Message;

public class MessageDecoratorBasic implements MessageDecorator{

    @Override
    public String decorate(Message message) {
        return message.prefix() + message.getData();
    }
}
