package com.acme.edu.message;

public class IntArrayMessage extends Message {
    private int[] message;

    public int[] getMessage() {
        return message;
    }

    public IntArrayMessage(int[] message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
