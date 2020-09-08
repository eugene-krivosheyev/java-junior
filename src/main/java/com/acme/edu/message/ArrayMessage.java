package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging Arrays
 * @see AbstractMessage
 */
public class ArrayMessage extends AbstractMessage {

    public ArrayMessage(int[] message) {
        PREFIX = "primitives array: ";
        messageController.setLength(0);
        prepareMessage(new ArrayList<>(Collections.singleton(message)));
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        String preparedMessage = Arrays.toString((int[]) listOfLog.get(0));
        messageController.append(PREFIX).append(preparedMessage);
    }
}
