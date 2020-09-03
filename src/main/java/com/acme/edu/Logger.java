package com.acme.edu;

public class Logger {

    private static String primitiveType = "primitive: ";

    private static String charType = "char: ";

    private static String stringType = "string: ";

    private static String referenceType = "reference: ";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void log(int message) {
        printMessage(primitiveType + message);
    }

    public static void log(byte message) {
        printMessage(primitiveType + message);
    }

    public static void log(char message) {
        printMessage(charType + message);
    }

    public static void log(String message) {
        printMessage(stringType + message);
    }

    public static void log(boolean message) {
        printMessage(primitiveType + message);
    }

    public static void log(Object message) {
        printMessage(referenceType + message);
    }
}
