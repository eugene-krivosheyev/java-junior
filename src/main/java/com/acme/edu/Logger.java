package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) { print(createMessage(PRIMITIVE_PREFIX, message)); }

    public static void log(byte message) { print(createMessage(PRIMITIVE_PREFIX, message)); }

    public static void log(char message) { print(createMessage(CHAR_PREFIX, message)); }

    public static void log(String message) { print(createMessage(STRING_PREFIX, message)); }

    public static void log(boolean message) { print(createMessage(PRIMITIVE_PREFIX, message)); }

    public static void log(Object message) { print(createMessage(REFERENCE_PREFIX, message)); }

    private static String createMessage(String nameType, Object message) {
        return nameType + message;
    }

    private static void print(String message) { System.out.println(message); }
}
