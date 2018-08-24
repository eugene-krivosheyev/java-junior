package com.acme.edu;

public class IntMessage implements Message{
    private int value;

    public IntMessage(int message) {
        this.value = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + value;
    }

    @Override
    public Message accumulate(Message message) {
        return new IntMessage(this.value + ((IntMessage)message).value);
    }

    @Override
    public boolean isSameType(Message message) {
        if (message == null) return false;
        return message instanceof IntMessage;
    }
}
