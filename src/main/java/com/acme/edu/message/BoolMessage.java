package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging Booleans.
 * @see AbstractMessage
 */
public class BoolMessage extends AbstractMessage {
    protected boolean boolValue;
    private static final String PREFIX = "primitive: ";

    public BoolMessage(boolean message) {
        boolValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        messageController
                .append(PREFIX)
                .append(((BoolMessage)listOfLog.get(0)).boolValue);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof BoolMessage;
    }
}
