package com.acme.edu.model;

import com.acme.edu.model.message.Message;
import com.acme.edu.model.message.NullMessage;


public class MessageContainer {
    private Message lastMessage = new NullMessage();

    public void addMessage(Message message) {
        if (lastMessage.canJoinMessage(message)) {
            lastMessage = lastMessage.getJoinedMessage(message);
        } else {
            flush();
            lastMessage = message;
        }
    }

    public void flush() {
        System.out.println(lastMessage.toString());
        lastMessage = new NullMessage();
    }
}
