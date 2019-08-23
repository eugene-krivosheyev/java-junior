package com.acme.edu;

import java.util.Arrays;

class PrintUtils {
    private PrintUtils() {
        throw new IllegalStateException("Utility class");
    }

    static void printToStdout(String message) {
        System.out.println(message);
    }

    static String arrayToString(int[] array) {
        return Arrays.toString(array)
                .replace("[", "{")
                .replace("]", "}");
    }

    static String arrayToString(int[][] array) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int[] subArray : array) {
            sb.append(arrayToString(subArray)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
