package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of AbstractMessage for logging References.
 * @see AbstractMessage
 */
public class ReferenceMessage extends AbstractMessage{

    public ReferenceMessage(Object message) {
        PREFIX = "reference: ";
        messageController.setLength(0);
        messageController
                .append(PREFIX)
                .append(message);
    }

    @Override
    public void prepareMessage(ArrayList<AbstractMessage> listOfLog) {}

    @Override
    public boolean isSameType(AbstractMessage message) {
        return message instanceof ReferenceMessage;
    }
}
