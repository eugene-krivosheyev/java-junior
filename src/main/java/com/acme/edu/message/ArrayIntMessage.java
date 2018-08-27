package com.acme.edu.message;

import java.util.Arrays;

public class ArrayIntMessage extends Message {
    private static final String TYPE_NAME = "primitives array";
    private int[] value;

    public ArrayIntMessage(int[] message) {
        this.value = message.clone();
        type = TYPE_NAME;
    }

    @Override
    public String getFormattedMessage() {
        return super.getFormattedString(Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}')
        );
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return false;
    }
}
