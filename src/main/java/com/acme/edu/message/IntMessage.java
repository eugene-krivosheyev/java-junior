package com.acme.edu.message;

import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * Extension of AbstractMessage for logging Integer message type.
 * Supports processing consecutive Integer messages and type overflow.
 * @see AbstractMessage
 */
public class IntMessage extends AbstractMessage {
    protected int intValue;
    private static final String PREFIX = "primitive: ";

    public IntMessage(int message) {
        this.intValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        int resultIntSum = 0;
        for (AbstractMessage currentMessage : listOfLog) {
            int currentValue = ((IntMessage) currentMessage).intValue;

            if (Integer.MAX_VALUE - resultIntSum < currentValue) {
                resultIntSum = currentValue - (Integer.MAX_VALUE - resultIntSum);
                messageController
                        .append(PREFIX)
                        .append(Integer.MAX_VALUE)
                        .append(lineSeparator());
            } else {
                resultIntSum += currentValue;
            }
        }
        messageController.append(PREFIX).append(resultIntSum);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof IntMessage;
    }
}
