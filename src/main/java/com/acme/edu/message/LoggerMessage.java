package com.acme.edu.message;

import com.acme.edu.data.MessageType;

public abstract class LoggerMessage {
    private final MessageType messageType;

    public LoggerMessage(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}
