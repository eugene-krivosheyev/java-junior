package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) { createAndPrintMessage(PRIMITIVE_PREFIX, message); }

    public static void log(byte message) { createAndPrintMessage(PRIMITIVE_PREFIX, message); }

    public static void log(char message) { createAndPrintMessage(CHAR_PREFIX, message); }

    public static void log(String message) { createAndPrintMessage(STRING_PREFIX, message); }

    public static void log(boolean message) { createAndPrintMessage(PRIMITIVE_PREFIX, message); }

    public static void log(Object message) { createAndPrintMessage(REFERENCE_PREFIX, message); }

    private static void createAndPrintMessage(String nameType, Object message) {
        String fullMessage = nameType + message;
        print(fullMessage);
    }

    private static void print(String message) { System.out.println(message); }
}
