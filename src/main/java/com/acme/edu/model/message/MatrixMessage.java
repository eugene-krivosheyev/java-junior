package com.acme.edu.model.message;

public class MatrixMessage extends UnableToJoinMessage{
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
    public Integer getBody() {
        return sum;
    }
}
