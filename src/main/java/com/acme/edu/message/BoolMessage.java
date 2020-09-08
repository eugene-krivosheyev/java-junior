package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging Booleans.
 * @see AbstractMessage
 */
public class BoolMessage extends AbstractMessage {

    public BoolMessage(boolean message) {
        PREFIX = "primitive: ";
        messageController.setLength(0);
        messageController
                .append(PREFIX)
                .append(message);
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {}

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof BoolMessage;
    }
}
