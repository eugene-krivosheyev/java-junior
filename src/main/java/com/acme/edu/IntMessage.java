package com.acme.edu;

import com.acme.edu.decorators.Decorator;
import com.acme.edu.decorators.IntDecorator;

public class IntMessage implements Message{
    private int value;
    private static Decorator decorator = new IntDecorator();


    public IntMessage(int message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return decorator.decorate("" + value);
    }

    @Override
    public Message accumulate(Message message) {
        return new IntMessage(this.value + ((IntMessage)message).value);
    }

    @Override
    public boolean isSameType(Message message) {
        if (message == null) return false;
        return message instanceof IntMessage;
    }
}
