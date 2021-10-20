package com.acme.edu.model;

import com.acme.edu.model.message.Message;

import java.util.ArrayList;
import java.util.List;


public class MessageContainer {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
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

    public boolean isNotEmpty(){
        return !messages.isEmpty();
    }
}
