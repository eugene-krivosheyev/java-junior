package com.acme.edu;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        logPrimitive(Integer.toString(message));
    }

    public static void log(byte message) {
        logPrimitive(Byte.toString(message));
    }

    public static void log(boolean message) {
        logPrimitive(Boolean.toString(message));
    }

    public static void log(char message) {
        System.out.println(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        System.out.println(STRING_PREFIX + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message);
    }

    private static void logPrimitive(String message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }
}
