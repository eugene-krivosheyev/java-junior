package com.acme.edu.message;

import java.util.ArrayList;

import static java.lang.System.lineSeparator;

public class ByteMessage extends AbstractMessage {

    public ByteMessage(ArrayList<Object> listOfLog) {
        PREFIX = "primitive: ";
        messageController.setLength(0);
        prepareMessage(listOfLog);
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        byte resultByteSum = 0;
        for (Object currentValue : listOfLog) {
            if (Byte.MAX_VALUE - resultByteSum < (byte) currentValue) {
                resultByteSum = (byte) ((byte) currentValue - (Byte.MAX_VALUE - resultByteSum));
                messageController
                        .append(PREFIX)
                        .append(Byte.MAX_VALUE)
                        .append(lineSeparator());
            } else {
                resultByteSum += (byte) currentValue;
            }
        }
        messageController.append(PREFIX).append(resultByteSum);
    }
}
