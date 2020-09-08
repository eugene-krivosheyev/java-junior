package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;

import com.acme.edu.saver.Saver;

/**
 * Class that represents input message of type Int
 *
 */
public class IntMessage extends LoggerMessage {

    private int message;
    /** Amount of times the IntOverflow occured */
    private int maxIntValueAmount = 0;
    /** Sum of all previous IntMessage content */
    private int currentIntMessage;

    public IntMessage(int message) {
        super(MessageType.INT, MessagePrefix.PRIMITIVE_PREFIX);
        this.message = message;
    }

    /**
     * Accumulate current massage content with previous (sum of integers with overflow check)
     *
     * @param intMessage
     */
    public void accumulateMessage(LoggerMessage intMessage) {
        long result = (long) ((IntMessage) intMessage).getMessage() + (long) currentIntMessage;
        if (result > Integer.MAX_VALUE) {
            currentIntMessage = (int) (result - Integer.MAX_VALUE);
            maxIntValueAmount++;
        } else {
            currentIntMessage = (int) result;
        }
    }

    /**
     * Create decorated message with prefixes
     *
     * @return String decoratedMessage
     * @see MessagePrefix
     */
    @Override
    public String createMessageWithPrefix() {
        return referencePrefix.getPrefixString() + currentIntMessage;
    }

    /**
     * Create overflow decorated message (Integer.MAX_VALUE with prefix)
     *
     * @return String decoratedMessage
     * @see MessagePrefix
     */
    private String createMessageWithOverflow() {
        return referencePrefix.getPrefixString() + Integer.MAX_VALUE;
    }

    /**
     * Check if message type is the same as the previous message type
     *
     * @param message
     * @return boolean result
     */
    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof IntMessage;
    }

    /**
     * Decorate accumulated message
     * Save accumulated message
     *
     * @param saver
     */
    @Override
    public void printMessageBuffer(Saver saver) {
        saver.print(this.createMessageWithPrefix());
        for (int i = 0; i < maxIntValueAmount; i++) {
            saver.print(this.createMessageWithOverflow());
        }
        this.currentIntMessage = 0;
        this.maxIntValueAmount = 0;
    }

    public int getMessage() {
        return message;
    }

}
