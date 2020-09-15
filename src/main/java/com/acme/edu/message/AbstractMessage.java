package com.acme.edu.message;

import java.util.List;

/**
 * Abstract class for any simple message type.
 * Supports message view handler that should be specified
 * for every message type.
 */
public abstract class AbstractMessage {
    public static StringBuilder messageController = new StringBuilder();

    /**
     * Preforms specific message formatting using message prefix.
     */
    public abstract void prepareMessage(List<AbstractMessage> listOfLog);

    /**
     * Returns boolean flag that identifies whether some AbstractMessage
     * child has the same type as current one.
     */
    public abstract boolean isSameType(AbstractMessage message);

    /**
     * Returns prepared string message from buffer and clears it afterwards.
     */
    public String getPreparedMessage() {
        return messageController.toString();
    };

    public void clearMessageBuffer() {
        messageController.setLength(0);
    }
}
