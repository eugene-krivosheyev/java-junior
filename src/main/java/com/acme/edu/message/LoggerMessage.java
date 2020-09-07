package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;

public abstract class LoggerMessage {
    protected final MessageType messageType;
    protected final MessagePrefix referencePrefix;

    public LoggerMessage(MessageType messageType, MessagePrefix referencePrefix) {
        this.messageType = messageType;
        this.referencePrefix = referencePrefix;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public abstract void accumulateMessage(LoggerMessage message);

    public abstract void printMessageBuffer();

    public abstract boolean isSameType(LoggerMessage message);

    public abstract String createMessageWithPrefix();

}
