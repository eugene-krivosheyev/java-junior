package com.acme.edu.message;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * Extension of AbstractMessage for logging 2D Array of Integers message type.
 * @see AbstractMessage
 */
public class MatrixMessage extends AbstractMessage {
    protected int[][] matrixValue;
    private static final String PREFIX = "primitives matrix: ";

    public MatrixMessage(int[][] message) {
        this.matrixValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        int[][] preparedMatrix = ((MatrixMessage) listOfLog.get(0)).matrixValue;
        String preparedMessage = Arrays.deepToString(preparedMatrix)
                .replace("], ", "]" + lineSeparator());

        messageController.append(PREFIX).append(preparedMessage);
    };

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof MatrixMessage;
    }
}
