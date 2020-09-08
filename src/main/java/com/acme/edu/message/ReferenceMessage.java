package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging References.
 * @see AbstractMessage
 */
public class ReferenceMessage extends AbstractMessage{
    protected Object referenceValue;
    private static final String PREFIX = "reference: ";

    public ReferenceMessage(Object message) {
        referenceValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        messageController
                .append(PREFIX)
                .append(((ReferenceMessage)listOfLog.get(0)).referenceValue);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ReferenceMessage;
    }
}
