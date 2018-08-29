package com.acme.edu.decorator;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

public class BinaryIntDecorator extends DefaultIntDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
        return Integer.toBinaryString(((IntMessage)message).getMessage());
    }

}