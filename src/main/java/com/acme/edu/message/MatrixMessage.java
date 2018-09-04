package com.acme.edu.message;

import com.acme.edu.exception.DecorateException;

public class MatrixMessage implements Message {
    private final String PREFIX = "primitives matrix";
    private final String SEPARATOR = ": ";

    private int[][] accumulatedMessage;
    private String decoratedMessage;

    public MatrixMessage(int[][] rawMessage) {
        this.accumulatedMessage = rawMessage;
        this.decoratedMessage = "";
    }

    @Override
    public Message accumulate(Message message) {
        return this;
    }

    @Override
    public Message decorate() throws DecorateException {
        int[][] array = accumulatedMessage;
        StringBuilder array2DAsString = new StringBuilder();
        try {
            array2DAsString.append("{").append(System.lineSeparator());
            for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
                array2DAsString.append(decorate1DArray(array[currentIndex])).append(System.lineSeparator());
            }
            array2DAsString.append("}").append(System.lineSeparator());
            decoratedMessage = PREFIX + SEPARATOR + array2DAsString.toString();
        } catch (Exception e) {
            throw new DecorateException(e);
        }
        return this;
    }

    @Override
    public boolean isInstanceOf(Message message) {
        return message instanceof MatrixMessage;
    }

    @Override
    public String getDecoratedString() {
        return decoratedMessage;
    }

    private String decorate1DArray(int[] currentMessageToDecorate) {
        int[] array = currentMessageToDecorate;
        StringBuilder arrayAsString = new StringBuilder();
        arrayAsString.append("{");
        for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
            if (currentIndex < array.length - 1) {
                arrayAsString.append(array[currentIndex]).append(", ");
            } else {
                arrayAsString.append(array[currentIndex]);
            }
        }
        arrayAsString.append("}");
        return arrayAsString.toString();
    }
}
