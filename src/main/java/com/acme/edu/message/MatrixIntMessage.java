package com.acme.edu.message;

import com.acme.edu.decorator.LoggerDecorator;

import java.util.Arrays;

public class MatrixIntMessage extends Message {
    private static final String TYPE_NAME = "primitives matrix";
    private int[][] value;

    public MatrixIntMessage(int[][] message) {
        this.value = message.clone();
        type = TYPE_NAME;
    }

    public int[][] getValue() {
        return value;
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return decorator.decorate(this);
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
