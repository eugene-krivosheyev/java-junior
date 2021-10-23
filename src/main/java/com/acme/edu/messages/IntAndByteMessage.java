package com.acme.edu.messages;

import com.acme.edu.Printer;

public abstract class IntAndByteMessage implements Message {

    private int messageValue;
    private static String messagePrefix = "primitive: ";
    private static int bufferSum;

    public IntAndByteMessage(int message) {
        this.messageValue = message;
    }

    @Override
    public Message accumulate(Message message) {
        int maxVALUE = maxValueOfThisType();
        if ((Long.valueOf(bufferSum) + Long.valueOf(((IntAndByteMessage) message).messageValue)) < maxVALUE) {
            bufferSum += ((IntAndByteMessage) message).messageValue;
            return message;
        } else {
            Printer.print(Integer.toString(maxVALUE));
            bufferSum = ((IntAndByteMessage) message).messageValue - (maxVALUE - bufferSum);
            return instanceOfThisClass(bufferSum);
        }
    }

    @Override
    public String getBody() {
        return messagePrefix + messageValue;
    }

    @Override
    public void flush() {
        Printer.print(messagePrefix + bufferSum);
        bufferSum = 0;
    }

    @Override
    public void init() {
        bufferSum += messageValue;
    }

    protected abstract Message instanceOfThisClass(int bufferSum);

    protected abstract int maxValueOfThisType();
}
