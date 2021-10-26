package com.acme.edu.messages;

public class ByteMessage extends IntAndByteMessage implements Message {
    public ByteMessage(int message) {
        super(message);
    }

    @Override
    protected Message instanceOfThisClass(int bufferSum) {
        return new ByteMessage(bufferSum);
    }

    @Override
    protected int maxValueOfThisType() {
        return Byte.MAX_VALUE;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }
}

