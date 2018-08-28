package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public class ByteMessage implements Message {
    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        if (!(comparedMessage instanceof ByteMessage)) return false;
        ByteMessage castedMessage = (ByteMessage) comparedMessage;
        int sum = (int) castedMessage.message + (int) this.message;
        return sum <= Byte.MAX_VALUE && sum >= Byte.MIN_VALUE;
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
