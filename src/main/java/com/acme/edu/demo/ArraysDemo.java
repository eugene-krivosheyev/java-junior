package com.acme.edu.demo;

import java.util.ArrayList;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        int[][] array = new int[10][5];
        System.out.println(array[10]);
        System.out.println(array.length);

        int[] readyArray = {1,2,3};
        m(new int[] {1,2});
    }

    private static void m(int[] params) {
        for (int param : params) {
            System.out.println(param);
        }
    }
}
