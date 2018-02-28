package com.acme.edu;

public class Logger {
    public static void log(int message) {
        printPrimitive(message);
    }

    public static void log(byte message) {
        printPrimitive(message);
    }

    public static void log(boolean message) {
        printPrimitive(message);
    }

    public static void log(char message) {
        print("char: " + message);
    }

    public static void log(String message) {
        print("string: " + message);
    }

    public static void log(Object message) {
        print("reference: " + message);
    }



    private static void printPrimitive(Object message) {
        print("primitive: " + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
