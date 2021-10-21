package com.acme.edu.processors;

import com.acme.edu.messageOut.Printer;

public class IntMessage implements Message {

    public int messageValue;
    private static String messagePrefix = "primitive: ";
    private static int bufferSum;

    public IntMessage(int message){
        this.messageValue = message;
    }

    @Override
    public Message accumulate(Message message) {
        if ((Long.valueOf(bufferSum) + Long.valueOf(((IntMessage)message).messageValue)) < Integer.MAX_VALUE) {
            bufferSum += ((IntMessage)message).messageValue;
            return message;
        } else {
            Printer.print(Integer.toString(Integer.MAX_VALUE));
            bufferSum = ((IntMessage)message).messageValue - (Integer.MAX_VALUE - bufferSum);
            return new IntMessage(bufferSum);
        }
    }
    @Override
    public boolean isSameType(Message message){
        boolean isSameType = message instanceof IntMessage;
        return isSameType;
    }

    @Override
    public String getBody() {
        return formatMessage();
    }

    @Override
    public void flush(){
        Printer.print(formatMessage());
        bufferSum = 0;
    }

    private String formatMessage() {
        return messagePrefix + messageValue;
    }


}
