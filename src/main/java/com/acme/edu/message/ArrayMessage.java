package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of AbstractMessage for logging Arrays.
 * @see AbstractMessage
 */
public class ArrayMessage extends AbstractMessage {

    public ArrayMessage(int[] message) {
        PREFIX = "primitives array: ";
        messageController.setLength(0);
        String preparedMessage = Arrays.toString(message);
        messageController.append(PREFIX).append(preparedMessage);
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {}

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ArrayMessage;
    }
}
