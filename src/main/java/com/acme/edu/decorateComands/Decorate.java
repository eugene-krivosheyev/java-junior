package com.acme.edu.decorateComands;

import java.util.Arrays;

public interface Decorate {
    static String decorateArray2D(int[][] message) {
        StringBuilder finalMessage = new StringBuilder("{\n");
        for (int[] integers : message) {
            finalMessage.append(Arrays.toString(integers)).append("\n");
        }
        finalMessage.append("}");
        return finalMessage.toString();
    }
}
