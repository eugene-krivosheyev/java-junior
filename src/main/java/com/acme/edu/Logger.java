package com.acme.edu;

public class Logger {

    public static final String typePrimitive = "pimitive: ";
    public static final String typeChar = "char: ";
    public static final String typeString = "string: ";
    public static final String typeReference = "reference: ";

    public static void log(String prefixType, Object message) {
        printToConsole(prefixType + message);
    }

    private static void printToConsole(String message) {
        System.out.println(message);
    }
}
