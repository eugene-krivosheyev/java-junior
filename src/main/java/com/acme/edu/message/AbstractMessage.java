package com.acme.edu.message;

import java.util.ArrayList;

/**
 * Abstract class for any message type that we want to log.
 * Supports prefix for messages, e.g. type description, and
 * message view handler that should be specified for every
 * message type.
 */
public abstract class AbstractMessage {
    static protected String PREFIX = "";
    protected StringBuilder messageController = new StringBuilder();

    public String getProcessedMessage() {
        return messageController.toString();
    }

    public abstract void prepareMessage(ArrayList<AbstractMessage> listOfLog);
    public abstract boolean isSameType(AbstractMessage message);

}
