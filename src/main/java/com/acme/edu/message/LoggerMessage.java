package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;

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
     * Function for getting field {@link LoggerMessage#messageType}
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Function for accumulating current message with @param message
     */
    public abstract void accumulateMessage(LoggerMessage message);

    /**
     * Function for printing current message
     */
    public abstract void printMessageBuffer();

    /**
     * Function for checking if current {@link LoggerMessage#messageType} is the same as in @param message
     */
    public abstract boolean isSameType(LoggerMessage message);

    /**
     * Function for creating message with prefix from {@link LoggerMessage#referencePrefix}
     */
    public abstract String createMessageWithPrefix();

}
