package com.acme.edu.model.message;

public interface Message {
    Message getJoinedMessage(Message message);

    boolean canJoinMessage(Message message);
}
