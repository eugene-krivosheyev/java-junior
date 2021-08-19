package com.db.edu;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static <T> void printLog(String name, T message) {
        System.out.println(name + message);
    }

    public static void log(int message) {
        printLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        printLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        printLog(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        printLog(STRING_PREFIX, message);
    }

    public static void log(boolean message) {
        printLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        printLog(REFERENCE_PREFIX, message);
    }
}
