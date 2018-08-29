package com.acme.edu;

import com.acme.edu.decorators.ByteDecorator;
import com.acme.edu.decorators.Decorator;

public class ByteMessage implements Message {
    private byte value;
    private Decorator decorator;

    public ByteMessage(byte value, Decorator decorator) {
        this.value = value;
        this.decorator = decorator;
    }


    @Override
    public String decorate() {
        return decorator.decorate("" + value);
    }

    @Override
    public Message accumulate(Message message) {
        return new ByteMessage ((byte)(value + ((ByteMessage)message).value), decorator);
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }
}
