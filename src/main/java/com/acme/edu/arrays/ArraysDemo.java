package com.acme.edu.arrays;

public class ArraysDemo {
    public static final int LENGTH = 5;

    public static void main(String... args) {
        int[] array = new int[LENGTH];
        array[0] = 0;
        System.out.println(array.length);

        int[][] matrix = new int[5][];
        matrix[0] = new int[0];
        matrix[1] = new int[1];
        matrix[2] = new int[2];
        System.out.println(matrix[0]);

        String[][] strArray = {
                {new String("1")},
                {new String("2")}
        };

        m(1);
    }

    static String m(int p, int... aaaa) {
        return null;
    }

    private static void m(int... param) {
        System.out.println(param[10]);
    }
}
