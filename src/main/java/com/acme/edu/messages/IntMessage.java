package com.acme.edu.messages;

public class IntMessage extends IntAndByteMessage implements Message {

    public IntMessage(int message) {
        super(message);
    }

    @Override
    protected Message instanceOfThisClass(int bufferSum) {
        return new IntMessage(bufferSum);
    }

    @Override
    protected int maxValueOfThisType() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntMessage;
    }


}
