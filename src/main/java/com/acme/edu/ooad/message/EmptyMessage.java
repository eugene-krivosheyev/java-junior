package com.acme.edu.ooad.message;

public class EmptyMessage implements Message {
    @Override
    public void clean() {
    }

    @Override
    public Message getNewInstance(Message message) {
        return message;
    }

    @Override
    public Message getInstanceToPrint(Message message) {
        return null;
    }

    @Override
    public String getBody() {
        return null;
    }
}
