package com.acme.edu.message;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * Extension of AbstractMessage for logging 4D Array of Integers message type.
 * @see AbstractMessage
 */
public class MultiMatrixMessage extends AbstractMessage {
    protected int[][][][] multiMatrixValue;
    private static final String PREFIX = "primitives multimatrix: ";

    public MultiMatrixMessage(int[][][][] message) {
        this.multiMatrixValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        int[][][][] preparedMultiMatrix = ((MultiMatrixMessage) listOfLog.get(0)).multiMatrixValue;
        String preparedMessage =
                Arrays.deepToString(preparedMultiMatrix)
                        .replace("]", lineSeparator() + "]")
                        .replace("[", "[" + lineSeparator());

        messageController.append(PREFIX).append(preparedMessage);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof MultiMatrixMessage;
    }
}
