package com.acme.edu.message;

public class IntArrayMessage implements Message {
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
    public String decorate() {
        StringBuilder decoratedString = new StringBuilder("primitives array: ");
        decoratedString.append(arrayToString());
        return decoratedString.toString();
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return false;
    }

    String arrayToString() {
        StringBuilder decoratedString = new StringBuilder();
        decoratedString.append("{");
        for (int i = 0; i < message.length - 1; ++i) {
            decoratedString.append(message[i]).append(", ");
        }
        if (message.length > 1) {
            decoratedString.append(message[message.length - 1]);
        }
        decoratedString.append("}");
        return decoratedString.toString();
    }
}
