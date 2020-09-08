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
    protected int[][] matrixValue;
    private static final String PREFIX = "primitives matrix: ";

    public MatrixMessage(int[][] message) {
        matrixValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        String preparedMessage = Arrays.deepToString(((MatrixMessage)listOfLog.get(0)).matrixValue)
                .replace("], ", "]" + lineSeparator());
        messageController.append(PREFIX).append(preparedMessage);
    };

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof MatrixMessage;
    }

}
