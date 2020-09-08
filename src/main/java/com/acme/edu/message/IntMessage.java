package com.acme.edu.message;

import java.util.ArrayList;

import static java.lang.System.lineSeparator;

/**
 * Implementation of AbstractMessage for logging Integers.
 * Supports flushing with type overflow.
 * @see AbstractMessage
 */
public class IntMessage extends AbstractMessage {
    protected int intValue;

    public IntMessage(int message) {
        messageController.setLength(0);
        PREFIX = "primitive: ";
        this.intValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        int resultIntSum = 0;
        for (Object currentValue : listOfLog) {
            if (Integer.MAX_VALUE - resultIntSum < (int) currentValue) {
                resultIntSum = (int) currentValue - (Integer.MAX_VALUE - resultIntSum);
                messageController
                        .append(PREFIX)
                        .append(Integer.MAX_VALUE)
                        .append(lineSeparator());
            } else {
                resultIntSum += (int) currentValue;
            }
        }
        messageController.append(PREFIX).append(resultIntSum);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof IntMessage;
    }
}
