package com.acme.edu.processors;

import java.util.Arrays;

public class ServiceForSumOfArray {
    public static int sumOfArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public static int sumOfArray2D(int[][] arr) {
        int sum = 0;
        for (int[] array : arr) {
            sum += sumOfArray(array);
        }
        return sum;
    }
}
