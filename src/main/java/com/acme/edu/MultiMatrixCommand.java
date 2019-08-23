package com.acme.edu;


import java.util.Arrays;

public class MultiMatrixCommand implements Command {
    private final int[][][][] message;

    public MultiMatrixCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.MULTIMATRIX_PREFIX + arrayToString(message);
    }

    static String arrayToString(int[][][][] array) {
        return Arrays.deepToString(array)
                .replace("[", "{\n")
                .replace("]", "}\n");
    }
}

