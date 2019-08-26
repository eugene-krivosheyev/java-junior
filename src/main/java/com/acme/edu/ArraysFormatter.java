package com.acme.edu;

public class ArraysFormatter {
    public static final String DELIMITER = ", ";

    public static String convertArrayToString(int[] array) {
        String temp = "{";
        for (int i = 0; i < array.length - 1; i++) {
            temp += array[i] + DELIMITER;
        }
        temp += array[array.length - 1] + "}";
        return temp;

    }

    public static String convertMatrixToString(int[][] matrix) {
        String temp = "{\n";
        for (int[] array : matrix) {
            temp += convertArrayToString(array) + "\n";
        }
        temp += "}";
        return temp;
    }

}
