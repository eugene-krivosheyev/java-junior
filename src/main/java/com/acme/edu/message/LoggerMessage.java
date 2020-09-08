package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.utils.Saver;

/**
 * Class that represents input messages
 */
public abstract class LoggerMessage {
    protected final MessageType messageType;
    /** Prefix that will be concatenated with the message */
    protected final MessagePrefix referencePrefix;

    public LoggerMessage(MessageType messageType, MessagePrefix referencePrefix) {
        this.messageType = messageType;
        this.referencePrefix = referencePrefix;
    }

    /**
     * Get field {@link LoggerMessage#messageType} content
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Accumulate current message with @param message
     */
    public abstract void accumulateMessage(LoggerMessage message);

    /**
     * Save accumulated decorated message
     */
    public abstract void printMessageBuffer(Saver saver);

    /**
     * Check if current {@link LoggerMessage#messageType} is the same as in @param message
     */
    public abstract boolean isSameType(LoggerMessage message);

    /**
     * Decorate message with prefix from {@link LoggerMessage#referencePrefix}
     */
    public abstract String createMessageWithPrefix();

}
