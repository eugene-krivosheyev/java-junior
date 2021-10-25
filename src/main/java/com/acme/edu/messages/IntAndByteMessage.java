package com.acme.edu.messages;

import com.acme.edu.Printer;

public abstract class IntAndByteMessage implements Message {
    private int messageBody;
    private static String messagePrefix = "primitive: ";
    private static int bufferSum;
    private Printer printer = new Printer();

    public IntAndByteMessage(int message) {
        this.messageBody = message;
    }

    @Override
    public Message accumulate(Message message) {
        int maxVALUE = maxValueOfThisType();
        if ((Long.valueOf(bufferSum) + Long.valueOf(((IntAndByteMessage) message).messageBody)) < maxVALUE) {
            bufferSum += ((IntAndByteMessage) message).messageBody;
            return message;
        } else {
            printer.print(Integer.toString(maxVALUE));
            bufferSum = ((IntAndByteMessage) message).messageBody - (maxVALUE - bufferSum);
            return instanceOfThisClass(bufferSum);
        }
    }

    @Override
    public String getBody() {
        return messagePrefix + messageBody;
    }

    @Override
    public String flush() {
        bufferSum = 0;
        return messagePrefix + bufferSum;
    }

    @Override
    public void init() {
        bufferSum += messageBody;
    }

    protected abstract Message instanceOfThisClass(int bufferSum);

    protected abstract int maxValueOfThisType();
}
