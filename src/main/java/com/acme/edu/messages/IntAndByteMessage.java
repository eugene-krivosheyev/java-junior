package com.acme.edu.messages;

public abstract class IntAndByteMessage implements Message {
    private int messageBody;
    private final String messagePrefix = "primitive: ";
    private int bufferSum;


    public IntAndByteMessage(int message) {
        this.messageBody = message;
        bufferSum = messageBody;
    }

    @Override
    public Message accumulate(Message message) {
        int maxVALUE = maxValueOfThisType();
        if (((long) bufferSum + (long) ((IntAndByteMessage) message).messageBody) < maxVALUE) {
            return instanceOfThisClass(bufferSum + ((IntAndByteMessage) message).messageBody);
        } else {
            System.out.println(Integer.toString(maxVALUE));
            return instanceOfThisClass(((IntAndByteMessage) message).messageBody - (maxVALUE - bufferSum));
        }
    }

    @Override
    public String getBody() {
        return messagePrefix + messageBody;
    }

    @Override
    public String flush() {
        String outString = messagePrefix + bufferSum;
        bufferSum = messageBody;
        return outString;
    }

    @Override
    public void init() {
        bufferSum += messageBody;
    }

    protected abstract Message instanceOfThisClass(int bufferSum);

    protected abstract int maxValueOfThisType();
}
