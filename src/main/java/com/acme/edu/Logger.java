package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE = "primitive: ";

    public static void log(int message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }
}
