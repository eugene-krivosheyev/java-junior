package com.acme.edu.message;

import java.util.Arrays;
import java.util.List;

/**
 * Extension of AbstractMessage for logging 1D Array of Integers message type.
 * @see AbstractMessage
 */
public class ArrayMessage extends AbstractMessage {
    protected int[] arrayValue;
    private static final String PREFIX = "primitives array: ";

    public ArrayMessage(int[] message) {
        this.arrayValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        int[] preparedArray = ((ArrayMessage) listOfLog.get(0)).arrayValue;
        String preparedMessage = Arrays.toString(preparedArray);

        messageController.append(PREFIX).append(preparedMessage);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ArrayMessage;
    }
}
