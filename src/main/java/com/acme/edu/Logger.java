package com.acme.edu;

public class Logger {

    public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: ";

    public static void log(int message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(byte message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(char message) {
        writeMessage(PREFIX_CHAR + message);
    }

    public static void log(boolean message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(String message) {
        writeMessage(PREFIX_STRING + message);
    }

    public static void log(Object message) {
        writeMessage(PREFIX_REFERENCE + message);
    }

    private static void writeMessage(String message) {
        System.out.println(message);
    }
}
