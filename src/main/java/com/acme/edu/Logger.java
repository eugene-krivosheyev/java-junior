package com.acme.edu;

public class Logger {

    private static final String primitivePrefix = "primitive: ";
    private static final String charPrefix = "char: ";
    private static final String stringPrefix = "string: ";
    private static final String referencePrefix = "reference: ";

    private static void print(String message) {
        System.out.println(message);
    }

    public static void log(int message) {
        print(primitivePrefix + message);
    }

    public static void log(byte message) {
        print(primitivePrefix + message);
    }

    public static void log(char message) {
        print(charPrefix + message);
    }

    public static void log(String message) {
        print(stringPrefix + message);
    }

    public static void log(boolean message) {
        print(primitivePrefix + message);
    }

    public static void log(Object message) {
        print(referencePrefix + message);
    }

}
