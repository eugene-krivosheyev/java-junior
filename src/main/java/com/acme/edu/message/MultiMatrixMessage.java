package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.lineSeparator;

/**
 * Implementation of AbstractMessage for logging Multidimensional Matrix.
 * @see AbstractMessage
 */
public class MultiMatrixMessage extends AbstractMessage {

    public MultiMatrixMessage(int[][][][] message) {
        PREFIX = "primitives multimatrix: ";
        messageController.setLength(0);
        String preparedMessage =
                Arrays.deepToString(message)
                        .replace("]", lineSeparator() + "]")
                        .replace("[", "[" + lineSeparator());
        messageController.append(PREFIX).append(preparedMessage);
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {}



    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof MultiMatrixMessage;
    }
}
