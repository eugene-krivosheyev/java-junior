package com.db.education.app;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    public static void log(int message) {
        getLogMessage(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        getLogMessage(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        getLogMessage(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        getLogMessage(STRING_PREFIX, message);
    }

    public static void log(boolean message) {
        getLogMessage(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        getLogMessage(OBJECT_PREFIX, message);
    }

    private static void getLogMessage(String prefix, Object message) {
        System.out.print(prefix + message + System.lineSeparator());
    }
}
