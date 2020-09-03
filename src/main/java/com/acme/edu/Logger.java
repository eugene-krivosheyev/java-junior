package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";

    public static void log(int message) { createAndPrintMessage(PRIMITIVE, message); }

    public static void log(byte message) { createAndPrintMessage(PRIMITIVE, message); }

    public static void log(char message) { createAndPrintMessage(CHAR, message); }

    public static void log(String message) { createAndPrintMessage(STRING, message); }

    public static void log(boolean message) { createAndPrintMessage(PRIMITIVE, message); }

    public static void log(Object message) { createAndPrintMessage(REFERENCE, message); }

    private static void createAndPrintMessage(String nameType, Object message) {
        String fullMessage = nameType + message;
        print(fullMessage);
    }

    private static void print(String message) { System.out.println(message); }
}
