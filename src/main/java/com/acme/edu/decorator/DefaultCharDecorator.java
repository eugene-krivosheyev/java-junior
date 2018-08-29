package com.acme.edu.decorator;

import com.acme.edu.message.CharMessage;
import com.acme.edu.message.Message;

public class DefaultCharDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return "char: " + ((CharMessage)message).getMessage();
    }

}
