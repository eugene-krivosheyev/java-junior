package com.db.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        saveOutput(decorateOutput(PRIMITIVE_PREFIX, message));
    }

    public static void log(byte message) {
        saveOutput(decorateOutput(PRIMITIVE_PREFIX, message));
    }

    public static void log(char message) {
        saveOutput(decorateOutput(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        saveOutput(decorateOutput(STRING_PREFIX, message));
    }

    public static void log(boolean message) {
        saveOutput(decorateOutput(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message.toString());
    }

    private static String decorateOutput(String prefix, Object message) {
        return prefix + message + System.lineSeparator();
    }

    private static void saveOutput(String decoratedMessage) {
        System.out.print(decoratedMessage);
    }
}