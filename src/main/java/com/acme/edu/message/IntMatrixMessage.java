package com.acme.edu.message;

public class IntMatrixMessage implements Message {
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
    public String decorate() {
        StringBuilder decoratedString = new StringBuilder("primitives matrix: ");
        decoratedString.append("{").append(System.lineSeparator());
        for (int[] row : message) {
            IntArrayMessage rowMessage = new IntArrayMessage(row);
            decoratedString.append(rowMessage.arrayToString())
                    .append(System.lineSeparator());
        }
        decoratedString.append("}");
        return decoratedString.toString();
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }
}
