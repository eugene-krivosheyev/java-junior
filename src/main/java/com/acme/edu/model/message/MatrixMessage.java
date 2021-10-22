package com.acme.edu.model.message;

public class MatrixMessage implements Message {
    private final int sum;

    public MatrixMessage(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        this.sum = result;
    }

    @Override
    public String toString() {
        return "primitives matrix: " + sum;
    }

    @Override
    public Message getJoinedMessage(Message message) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean canJoinMessage(Message message) {
        return false;
    }

    @Override
    public Integer getValue() {
        return sum;
    }
}
