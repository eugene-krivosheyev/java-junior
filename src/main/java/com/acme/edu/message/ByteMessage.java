package com.acme.edu.message;

import java.util.ArrayList;

import static java.lang.System.lineSeparator;

/**
 * Implementation of AbstractMessage for logging Bytes.
 * Supports flushing with type overflow.
 * @see AbstractMessage
 */
public class ByteMessage extends AbstractMessage {
    protected Byte byteValue;

    public ByteMessage(Byte message) {
        messageController.setLength(0);
        PREFIX = "primitive: ";
        this.byteValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
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

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ByteMessage;
    }
}
