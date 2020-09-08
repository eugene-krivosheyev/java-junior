package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.lineSeparator;

public class MultiMatrixMessage extends AbstractMessage {

    public MultiMatrixMessage(int[][][][] message) {
        PREFIX = "primitives multimatrix: ";
        messageController.setLength(0);
        prepareMessage(new ArrayList<>(Collections.singleton(message)));
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        String preparedMessage =
                Arrays.deepToString((Object[]) listOfLog.get(0))
                .replace("]", lineSeparator() + "]")
                .replace("[", "[" + lineSeparator());

        messageController.append(PREFIX).append(preparedMessage);
    }
}
