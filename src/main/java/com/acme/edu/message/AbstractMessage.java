package com.acme.edu.message;

import java.util.ArrayList;

/**
 * Abstract class for any message type that we want to log.
 * Supports message view handler that should be specified
 * for every message type.
 */
public abstract class AbstractMessage {

    public static StringBuilder messageController = new StringBuilder();

    public abstract void prepareMessage(ArrayList<AbstractMessage> listOfLog);
    public abstract boolean isSameType(AbstractMessage message);

}
