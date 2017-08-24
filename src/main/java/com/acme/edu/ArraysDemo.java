package com.acme.edu;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ArraysDemo {
    public static void main(String... args) {
        int[][] array = new int[5][];
        for (int[] elementL1 : array) {
            for (int elementL2 : elementL1) {
                System.out.print(elementL2 + " ");
            }
            System.out.println();
        }
        array[0] = new int[1];

        int[] array2 = new int[] {1, 3, 5}; //Array literal
        m(new int[] {1,2,3});
        m(1,2,3);

        int[][] matrix = {
                {1,2},
                {},
                {1,2,3,4}
        };

//        System.arraycopy();
    }

    private static void m(int... param) {
        if (!condition()) return; //Guard Clauses
        if (!condition()) return;
        if (!condition()) return;
        if (!condition()) return;
        if (!condition()) return;
        if (!condition()) return;
        if (!condition()) return;

        //main flow
        //main flow
        //main flow
        //main flow
    }
}
