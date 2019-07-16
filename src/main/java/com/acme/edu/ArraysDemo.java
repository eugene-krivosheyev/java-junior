package com.acme.edu;

public class ArraysDemo {
    public static void main(String[] args) {
        String[][] array = new String[10][1];
        array[0] = new String[0];
        array[1] = new String[3];
        System.out.println(array[0][1]);

        m(new int[] {1,2,3,4});
    }

    private static void m(int[] params) {
        for (int current : params) {
            System.out.println(current);
        }
    }
}
