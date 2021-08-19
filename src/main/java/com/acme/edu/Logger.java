package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String CHAR_PREFIX = "char";
    private static final String STRING_PREFIX = "string";
    private static final String OBJECT_PREFIX = "reference";

    public static void log(int message) {
        save(formatMessage(PRIMITIVE_PREFIX, message));
    }

    public static void log(byte message) {
        save(formatMessage(PRIMITIVE_PREFIX, message));
    }

    public static void log(char message) {
        save(formatMessage(CHAR_PREFIX, message));
    }

    public static void log(boolean message) {
        save(formatMessage(PRIMITIVE_PREFIX, message));
    }

    public static void log(String message) {
        save(formatMessage(STRING_PREFIX, message));
    }

    public static void log(Object message) {
        save(formatMessage(OBJECT_PREFIX, message));
    }

    private static String formatMessage(String prefix, Object message) {
        return prefix+": "+message+"\n";
    }

    private static void save(String message) {
        System.out.print(message);
    }
}

