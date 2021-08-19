package com.db.edu;


public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    public static void log(int message) {
        writeMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        writeMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(boolean message) {
        writeMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        writeMessage(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        writeMessage(STRING_PREFIX + message);
    }

    public static void log(Object message) {
        writeMessage(OBJECT_PREFIX + message);
    }

    private static void writeMessage(String s) {
        System.out.println(s);
    }
}