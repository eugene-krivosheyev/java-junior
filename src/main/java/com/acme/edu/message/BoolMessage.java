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
        this.boolValue = message;
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {
        boolean preparedBool = ((BoolMessage) listOfLog.get(0)).boolValue;
        messageController.append(PREFIX).append(preparedBool);
    }

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof BoolMessage;
    }
}
