package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class ByteMessage extends NumberMessage {

    private byte value;

    public ByteMessage(byte message) {
        value = message;
    }

    @Override
    public String getDecoratedString() {
        return "primitive: " + value;
    }

    @Override
    public boolean isSameType(Message message) {
        return (message instanceof ByteMessage);
    }

    @Override
    public Message clone() {
        return new ByteMessage(value);
    }

    @Override
    protected long getValue() {
        return value;
    }

    @Override
    protected void setValue(long value) {
        this.value = (byte) value;
    }

    @Override
    protected long getMaxValue() {
        return Byte.MAX_VALUE;
    }

    @Override
    protected NumberMessage createNumberMessage(long value) {
        return new ByteMessage((byte) value);
    }
}
