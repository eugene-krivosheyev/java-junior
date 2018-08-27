package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class ByteMessage implements Message {
    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        return  (comparedMessage instanceof ByteMessage);
    }

    @Override
    public Message accumulate(Message message) {
        ByteMessage byteMessage = (ByteMessage) message;
        this.message += byteMessage.message;
        return this;
    }

    @Override
    public String accept(DecoratorVisitor decoratorVisitor) {
        return decoratorVisitor.decorateByte(this.message);
    }
}
