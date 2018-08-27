package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class ByteMessage extends Message {
    private byte message;

    public ByteMessage(byte message, Decorator decorator) {
        super(decorator);
        this.message = message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        ByteMessage downcastedMessage =  (ByteMessage)nextMessage;
        return new ByteMessage((byte)(this.message + downcastedMessage.message), getDecorator());
    }

    @Override
    public String getDecoratedMessage() {
        getDecorator().setMessage(Byte.toString(message));
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }
}
