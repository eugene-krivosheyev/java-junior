package com.acme.edu.message;

import java.util.List;

/**
 * Abstract class for any message type that we want to log.
 * Supports message view handler that should be specified
 * for every message type.
 */
public abstract class AbstractMessage {
    public static StringBuilder messageController = new StringBuilder();

    public abstract void prepareMessage(List<AbstractMessage> listOfLog);
    public abstract boolean isSameType(AbstractMessage message);

    public String getPreparedMessage() {
        String preparedMessage = messageController.toString();
        messageController.setLength(0);
        return preparedMessage;
    };
}
