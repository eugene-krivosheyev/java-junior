package com.acme.edu.model.message;

import com.acme.edu.model.exception.LoggerException;

public interface Message {
    Message getAccumulatedMessage(Message message) throws LoggerException;

    boolean canAccumulateMessage(Message message);

    Object getBody();
}
