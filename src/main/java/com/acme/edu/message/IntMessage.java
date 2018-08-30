package com.acme.edu.message;

import com.acme.edu.decorators.Decorator;

public class IntMessage implements Message {
    private int value;
    private Decorator decorator;

    public IntMessage(int value, Decorator decorator) {
        this.value = value;
        this.decorator = decorator;
    }


    @Override
    public String decorate() {
        return decorator.decorate("" + value);
    }

    @Override
    public Message accumulate(Message message) {
        return new IntMessage(this.value + ((IntMessage)message).value, decorator);
    }

    @Override
    public boolean isSameType(Message message) {
        if (message == null) return false;
        return message instanceof IntMessage;
    }
}
