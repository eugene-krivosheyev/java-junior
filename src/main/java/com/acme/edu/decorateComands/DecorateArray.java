package com.acme.edu.decorateComands;

import java.util.Arrays;

public interface DecorateArray {
    static String collectData(int[][] message) {
        StringBuilder finalMessage = new StringBuilder("{\n");
        for (int[] integers : message) {
            finalMessage.append(Arrays.toString(integers)).append("\n");
        }
        finalMessage.append("}");
        return finalMessage.toString();
    }

    String decorate(int[][] message);
}
