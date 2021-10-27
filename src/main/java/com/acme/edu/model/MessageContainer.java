package com.acme.edu.model;

import com.acme.edu.model.exception.LoggerException;
import com.acme.edu.model.message.Message;
import com.acme.edu.model.message.NullMessage;


public class MessageContainer {
    private Message lastMessage = new NullMessage();

    public void addMessage(Message message) {
        try {
            if (lastMessage.canAccumulateMessage(message)) {
                lastMessage = lastMessage.getAccumulatedMessage(message);
            } else {
                flush();
                lastMessage = message;
            }
        } catch (LoggerException e) {
            System.out.println("Exception in addMessage");
        }
    }

    public void flush() {
        System.out.println(lastMessage.toString());
        lastMessage = new NullMessage();
    }
}
