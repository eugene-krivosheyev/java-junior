package com.acme.edu.message;

import java.util.List;

/**
 * Extension of AbstractMessage for logging Reference message type.
 * @see AbstractMessage
 */
public class ReferenceMessage extends AbstractMessage{
    protected Object referenceValue;
    private static final String PREFIX = "reference: ";

    public ReferenceMessage(Object message) {
        this.referenceValue = message;
    }

    @Override
    public void prepareMessage(List<AbstractMessage> listOfLog) {
        Object preparedReference = ((ReferenceMessage) listOfLog.get(0)).referenceValue;
        messageController.append(PREFIX).append(preparedReference);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ReferenceMessage;
    }
}
