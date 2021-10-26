package com.acme.edu.model;

import com.acme.edu.Logger;
import com.acme.edu.model.message.Message;
import com.acme.edu.model.message.NullMessage;

import java.util.ArrayList;
import java.util.List;


public class MessageContainer  {
    private Message lastMessage;

    public void addMessage(Message message) {
        if (lastMessage == null) {
            lastMessage = message;
        } else if (lastMessage.canJoinMessage(message)) {
            lastMessage = lastMessage.getJoinedMessage(message);
        } else {
            Logger.flush();
            lastMessage = message;
        }
    }

    public void flush() {
        System.out.println(lastMessage.toString());
        lastMessage = new NullMessage();
    }
}
