package com.acme.edu;

import java.util.Arrays;

public class ArrayCommand implements Command {
    private final int[] message;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.ARRAY_PREFIX + arrayToString(message);
    }

    static String arrayToString(int[] array) {
        return Arrays.toString(array)
                .replace("[", "{")
                .replace("]", "}");
    }
}
