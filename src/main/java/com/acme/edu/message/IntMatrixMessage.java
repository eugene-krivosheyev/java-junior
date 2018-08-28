package com.acme.edu.message;

public class IntMatrixMessage extends Message {
    int[][] message;

    public int[][] getMessage() {
        return message;
    }

    public IntMatrixMessage(int[][] message) {
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
