package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;

import com.acme.edu.utils.ConsoleSaver;

public class IntMessage extends LoggerMessage {

    private int message;

    private int maxIntValueAmount = 0; // overflow
    private int currentIntMessage; // sum int

    ConsoleSaver consoleSaver = new ConsoleSaver();

    public IntMessage(int message) {
        super(MessageType.INT, MessagePrefix.PRIMITIVE_PREFIX);
        this.message = message;
    }

    public void accumulateMessage(LoggerMessage intMessage) {
        long result = (long) ((IntMessage) intMessage).getMessage() + (long) currentIntMessage;
        if (result > Integer.MAX_VALUE) {
            currentIntMessage = (int) (result - Integer.MAX_VALUE);
            maxIntValueAmount++;
        } else {
            currentIntMessage = (int) result;
        }
    }

    @Override
    public String createMessageWithPrefix() {
        return referencePrefix.getPrefixString() + currentIntMessage;
    }

    private String createMessageWithOverflow() {
        return referencePrefix.getPrefixString() + Integer.MAX_VALUE;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof IntMessage;
    }

    @Override
    public void printMessageBuffer() {
        consoleSaver.print(this.createMessageWithPrefix());
        for (int i = 0; i < maxIntValueAmount; i++) {
            consoleSaver.print(this.createMessageWithOverflow());
        }
        this.currentIntMessage = 0;
        this.maxIntValueAmount = 0;
    }

    public int getMessage() {
        return message;
    }

}
