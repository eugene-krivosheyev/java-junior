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
    private static final String PREFIX = "primitive: ";

    public IntMessage(int message) {
        intValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        int resultIntSum = 0;
        for (AbstractMessage currentValue : listOfLog) {
            if (Integer.MAX_VALUE - resultIntSum < ((IntMessage)currentValue).intValue) {
                resultIntSum = ((IntMessage)currentValue).intValue - (Integer.MAX_VALUE - resultIntSum);
                messageController
                        .append(PREFIX)
                        .append(Integer.MAX_VALUE)
                        .append(lineSeparator());
            } else {
                resultIntSum += ((IntMessage)currentValue).intValue;
            }
        }
        messageController.append(PREFIX).append(resultIntSum);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof IntMessage;
    }
}
