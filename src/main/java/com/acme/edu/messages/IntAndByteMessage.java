package com.acme.edu.messages;

public abstract class IntAndByteMessage implements Message {
    private int messageBody;
    private static final String messagePrefix = "primitive: ";
    private static int bufferSum;


    public IntAndByteMessage(int message) {
        this.messageBody = message;
    }

    @Override
    public Message accumulate(Message message) {
        int maxVALUE = maxValueOfThisType();
        if (((long) bufferSum + (long) ((IntAndByteMessage) message).messageBody) < maxVALUE) {
            bufferSum += ((IntAndByteMessage) message).messageBody;
            return message;
        } else {
            System.out.println(Integer.toString(maxVALUE));
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
        String outString = messagePrefix + bufferSum;
        bufferSum = 0;
        return outString;
    }

    @Override
    public void init() {
        bufferSum += messageBody;
    }

    protected abstract Message instanceOfThisClass(int bufferSum);

    protected abstract int maxValueOfThisType();
}
