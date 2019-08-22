package com.acme.edu;

import java.util.Arrays;

class Decorator {

    // -------------- DECORATE STRING ------------------

    static void decorateString(String prefix, Object message) {
        System.out.println(prefix + message);
    }


    // -------------- DECORATE ARRAY ------------------

    static String decorateArray(int[] array) {
        return Arrays.toString(array).replace("[", "{").replace("]", "}") +"\n";
    }

    static String decorateArray(int[][] array) {
        StringBuilder result = new StringBuilder("{\n");
        for (int[] anArray : array) {
            result.append(Arrays.toString(anArray).replace("[", "{").replace("]", "}")).append("\n");
        }
        return result +"}\n";
    }

    static String decorateArray(int[][][][] array) {
        return Arrays.deepToString(array).replace("[", "{\n").replace("]", "\n}");
    }
}
