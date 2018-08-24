package com.acme.edu.message;

import java.util.Arrays;

public class MatrixIntMessage extends Message {
    private static final String TYPE_NAME = "primitives matrix";
    private int[][] value;

    public MatrixIntMessage(int[][] message) {
        this.value = message;
        type = TYPE_NAME;
    }


    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public String getFormattedMessage() {
        StringBuilder arrayStringBuilder = new StringBuilder();
        arrayStringBuilder
                .append('{')
                .append(System.lineSeparator());
        for (int[] arr: value) {
            arrayStringBuilder
                    .append(formatArray(arr))
                    .append(System.lineSeparator());
        }
        arrayStringBuilder
                .append('}');
        return getFormattedString(arrayStringBuilder.toString());
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return false;
    }

    private String formatArray(int[] array) {
        return Arrays.toString(array)
                .replace('[', '{')
                .replace(']', '}');
    }
}
