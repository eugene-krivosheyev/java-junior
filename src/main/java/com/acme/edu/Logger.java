package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        printMessageWithType(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        printMessageWithType(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        printMessageWithType(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        printMessageWithType(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        printMessageWithType(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printMessageWithType(REFERENCE_PREFIX + message);
    }

    private static void printMessageWithType(String message) {
        System.out.println(message);
    }
}
