package com.acme.edu;

public class Logger {

    static int sum;
    static {
        sum = 0;
    }

    public static void log(int message) { System.out.println("primitive: " + message); }

    public static void log(int message, boolean isFlush) {
        sum += message;
        if (isFlush) {
            System.out.println("primitive: " + sum);
            sum = 0;
        }
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }



}
