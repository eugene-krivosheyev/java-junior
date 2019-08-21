package com.acme.edu;

public class Logger {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        logPrimitive(String.valueOf(message));
    }

    public static void log(byte message) {
        logPrimitive(String.valueOf(message));
    }

    public static void log(boolean message) {
        logPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        logChar(String.valueOf(message));
    }

    public static void log(String message) {
        logString(message);
    }

    public static void log(Object message) {
        logObject(String.valueOf(message));
    }

    // region Decorators
    private static String decoratePrimitive(String message) {
        return PRIMITIVE_PREFIX + message;
    }

    private static String decorateString(String message) {
        return STRING_PREFIX + message;
    }

    private static String decorateReference(String message) {
        return REFERENCE_PREFIX + message;
    }

    private static String decorateChar(String message) {
        return CHAR_PREFIX + message;
    }
    // endregion

    // region Loggers for each type
    private static void logPrimitive(String message) {
        Printer.print(decoratePrimitive(message));
    }

    private static void logChar(String message) {
        Printer.print(decorateChar(message));
    }

    private static void logString(String message) {
        Printer.print(decorateString(message));
    }

    private static void logObject(String message) {
        Printer.print(decorateReference(message));
    }
    // endregion
}
