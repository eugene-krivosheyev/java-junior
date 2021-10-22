package com.acme.edu.model;

import com.acme.edu.model.message.Message;

import java.util.ArrayList;
import java.util.List;


public class MessageContainer  {
    private final List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        if (this.messages.size() == 0) {
            this.messages.add(message);
        } else if (getLastMessage().canJoinMessage(message)) {
            Message messageToAdd = getLastMessage().getJoinedMessage(message);
            messages.remove(getLastMessage());
            this.messages.add(messageToAdd);
        } else {
            this.messages.add(message);
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getText() {
        StringBuilder text = new StringBuilder();
        for (Message message : messages) {
            text.append(message.toString()).append(System.lineSeparator());
        }
        return text.toString();
    }


    public Message getLastMessage() {
        return messages.get(messages.size() - 1);
    }

}
