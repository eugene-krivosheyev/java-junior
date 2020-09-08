package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.lineSeparator;

/**
 * Implementation of AbstractMessage for logging Matrix.
 * @see AbstractMessage
 */
public class MatrixMessage extends AbstractMessage {

    public MatrixMessage(int[][] message) {
        PREFIX = "primitives matrix: ";
        messageController.setLength(0);
        String preparedMessage = Arrays.deepToString(message)
                        .replace("], ", "]" + lineSeparator());
        messageController.append(PREFIX).append(preparedMessage);
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {};

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof MatrixMessage;
    }

}
