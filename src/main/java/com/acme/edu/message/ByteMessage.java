package com.acme.edu.message;

public class ByteMessage implements Message {
    private byte value;
    private String prefix = "primitive: ";

    public ByteMessage(byte value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public void updateAccumulator(Message message) {
        value += (byte)message.getValue();
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public boolean needFlush(Message message) {
        int safe = value;
        safe += (byte)message.getValue();
        return (safe > Byte.MAX_VALUE);
    }

    @Override
    public String toString() {
        return prefix + value;
    }
}
