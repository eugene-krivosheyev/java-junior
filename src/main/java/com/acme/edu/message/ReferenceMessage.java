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
        prepareMessage(new ArrayList<>(Collections.singleton(message)));
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        messageController
                .append(PREFIX)
                .append(listOfLog.get(0));
    }
}
