package com.acme.edu.message;

import com.acme.edu.data.MessageType;

public class IntMessage extends LoggerMessage {

    private int message;
    private static int maxIntValueAmount = 0;

    private static int currentIntMessage;


    public IntMessage(int message) {
        super(MessageType.INT);
        this.message = message;
    }

    public void addMessage() {
        long result = (long) message + (long) currentIntMessage;
        if (result > Integer.MAX_VALUE) {
            currentIntMessage = (int) (result - Integer.MAX_VALUE);
            maxIntValueAmount++;
        } else {
            currentIntMessage = (int) result;
        }
    }


}
