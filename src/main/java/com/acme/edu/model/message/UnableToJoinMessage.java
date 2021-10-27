package com.acme.edu.model.message;

import com.acme.edu.model.exception.LoggerException;

public abstract class UnableToJoinMessage implements Message {

    public Message getAccumulatedMessage(Message message) throws LoggerException {
        throw new LoggerException("Unable to join message for this class", new IllegalStateException());
    }

    public boolean canAccumulateMessage(Message message) {
        return false;
    }
}
