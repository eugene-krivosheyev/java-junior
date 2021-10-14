package com.acme.edu;

public class Logger {

    public static final String typePrimitive = "pimitive: ";
    public static final String typeChar = "char: ";
    public static final String typeString = "string: ";
    public static final String typeReference = "reference: ";

    private static void printToConsole(String message) {
        System.out.println(message);
    }

    public static void log(int message) {
        printToConsole(typePrimitive + message);
    }

    public static void log(byte message) {
        printToConsole(typePrimitive + message);
    }

    public static void log(char message) {
        printToConsole(typeChar + message);
    }

    public static void log(String message) {
        printToConsole(typeString + message);
    }

    public static void log(boolean message) {
        printToConsole(typePrimitive + message);
    }

    public static void log(Object message) {
        printToConsole(typeReference + message);
    }
}
