package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.Map;

public class ByteMessage extends Message {
    private byte message;

    public byte getMessage() {
        return message;
    }

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return new ByteMessage((byte) (this.message + ((ByteMessage) message).getMessage()));
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.BYTE));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof ByteMessage && !isOverflow(this.message, ((ByteMessage) message).message);
    }

    private boolean isOverflow(byte val1, byte val2) {
        return val1 > 0 ?
                Byte.MAX_VALUE - val1 < val2 :
                Byte.MIN_VALUE - val1 > val2;
    }
}
