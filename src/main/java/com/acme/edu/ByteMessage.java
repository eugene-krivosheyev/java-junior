package com.acme.edu;

import com.acme.edu.decorators.ByteDecorator;
import com.acme.edu.decorators.Decorator;

public class ByteMessage implements Message {
    private byte value;
    private static Decorator decorator = new ByteDecorator();

    public ByteMessage(byte message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return decorator.decorate("" + value);
    }

    @Override
    public Message accumulate(Message message) {
        return new ByteMessage ((byte)(value + ((ByteMessage)message).value));
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }
}
