package com.acme.edu.message;

import com.acme.edu.saver.Saver;

/**
 * Interface that represents input messages
 */
public interface LoggerMessage {
    /**
     * Accumulate current message with @param message
     */
    void accumulateMessage(LoggerMessage message);

    /**
     * Save accumulated decorated message
     */
    void printMessageBuffer(Saver saver);

    /**
     * Check if current message type is the same as in @param message
     */
    boolean isSameType(LoggerMessage message);

    /**
     * Decorate message with prefix
     */
    String createMessageWithPrefix();

}
