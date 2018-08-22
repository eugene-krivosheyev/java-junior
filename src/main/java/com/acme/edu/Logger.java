package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    public static void log(int message) {
        save(PRIMITIVE + message);
    }

    public static void log(byte message) {
        save(PRIMITIVE + message);
    }

    public static void log(char message) {
        save(CHAR + message);
    }

    public static void log(String message) {
        save(STRING + message);
    }

    public static void log(boolean message) {
        save(PRIMITIVE + message);
    }

    public static void log(Object message) {
        save(REFERENCE + message);
    }

    private static void save(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
