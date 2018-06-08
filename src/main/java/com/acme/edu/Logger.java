package com.acme.edu;

public class Logger {

    private static int integerChainSum;

    public static void flushIntegerBuffer() {
        System.out.println("primitive: " + integerChainSum);
        integerChainSum = 0;
    }


    public static void log(int message) {
        integerChainSum += message;
    }

    public static void log(byte message) {
        flushIntegerBuffer();
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        flushIntegerBuffer();
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        flushIntegerBuffer();
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        flushIntegerBuffer();
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        flushIntegerBuffer();
        System.out.println("reference: " + message);
    }

}
