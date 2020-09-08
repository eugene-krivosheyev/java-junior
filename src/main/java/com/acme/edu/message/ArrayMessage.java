package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of AbstractMessage for logging Arrays.
 * @see AbstractMessage
 */
public class ArrayMessage extends AbstractMessage {
    protected int[] arrayValue;
    private static final String PREFIX = "primitives array: ";

    public ArrayMessage(int[] message) {
        this.arrayValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        int[] preparedArray = ((ArrayMessage) listOfLog.get(0)).arrayValue;
        String preparedMessage = Arrays.toString(preparedArray);

        messageController.append(PREFIX).append(preparedMessage);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ArrayMessage;
    }
}
