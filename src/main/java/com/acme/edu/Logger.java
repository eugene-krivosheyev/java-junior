package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private Logger() {
    }

    private static String decorateLog(String prefix, Object message) {
        return prefix + message;
    }

    private static void writeLog(String prefix, Object message) {
        System.out.println(decorateLog(prefix, message));
    }

    public static void log(int message) {
        writeLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        writeLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        writeLog(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        writeLog(STRING_PREFIX, message);
    }

    public static void log(boolean message) {
        writeLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        writeLog(REFERENCE_PREFIX, message);
    }
}
