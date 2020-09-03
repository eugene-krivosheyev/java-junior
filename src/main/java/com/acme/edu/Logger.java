package com.acme.edu;

public class Logger {

    final public static String PRIMITIVE_PREFIX = "primitive: ";
    final public static String CHAR_PREFIX = "char: ";
    final public static String STRING_PREFIX = "string: ";
    final public static String OBJ_PREFIX = "reference: ";

    public static void log(int message) {
        printLogMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        printLogMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        printLogMessage(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        printLogMessage(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        printLogMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printLogMessage(OBJ_PREFIX + message);
    }

    public static void printLogMessage(String message) {
        System.out.println(message);
    }

}
