package com.acme.edu;

import java.util.Arrays;

public class Logger {

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: {";

    private static long sum = 0;
    private static boolean integerSequence = false;

    public static void log(int message) {
        integerSequence = true;
        sum = sum + message;
        overflowedSum(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static void overflowedSum(int maxValue, int minValue) {
        if (sum >= maxValue) {
            sum = sum - maxValue;
            System.out.println(maxValue);
        }

        else if (sum <= minValue) {
            sum = sum + minValue;
            System.out.println(minValue);
        }
    }

    public static void log(int[] message) {
        save(PRIMITIVES_ARRAY, message);
    }

    public static void log(int[][] message) {
        System.out.println(PRIMITIVES_MATRIX);
        for (int[] current : message)
            save("", current);
        System.out.println("}");
    }

    public static void log(byte message) {
        save(PRIMITIVE + message);
    }

    public static void log(char message) {
        save(CHAR + message);
    }

    public static void log(String message) {
        save(STRING + message);
    }

    public static void log(boolean message) {
        save(PRIMITIVE + message);
    }

    public static void log(Object message) {
        save(REFERENCE + message);

    }

    public static void flush(){
        System.out.println(PRIMITIVE + sum);
        sum = 0;
    }

    private static void save(String decoratedMessage) {
        if (integerSequence) {
            integerSequence = false;
            flush();
        }
        System.out.println(decoratedMessage);
    }

    private static void save(String decoratedMessage, int[] array) {
        System.out.print(decoratedMessage + "{");
        int length = array.length - 1;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i != length){
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
