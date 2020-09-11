package com.acme.edu.message;

import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * Extension of AbstractMessage for logging Byte message type.
 * Supports processing consecutive Byte messages and type overflow.
 * @see AbstractMessage
 */
public class ByteMessage extends AbstractMessage {
    protected Byte byteValue;
    private static final String PREFIX = "primitive: ";

    public ByteMessage(Byte message) {
        this.byteValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        byte resultByteSum = 0;
        for (AbstractMessage currentMessage : listOfLog) {
            Byte currentValue = ((ByteMessage)currentMessage).byteValue;

            if (Byte.MAX_VALUE - resultByteSum < currentValue) {
                resultByteSum = (byte) (currentValue - (Byte.MAX_VALUE - resultByteSum));
                messageController
                        .append(PREFIX)
                        .append(Byte.MAX_VALUE)
                        .append(lineSeparator());
            } else {
                resultByteSum += currentValue;
            }
        }
        messageController.append(PREFIX).append(resultByteSum);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ByteMessage;
    }
}
