package com.acme.edu.primitives;

public class IntOverflowTest {
    public static void main(String[] args) {
        int i1 = Integer.MAX_VALUE, i2 = 2;
        System.out.println((long)i1 + i2);
    }
}
