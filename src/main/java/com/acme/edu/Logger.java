package com.acme.edu;

public class Logger {
    private static final String primitivePrefix = "primitive: ";
    private static final String stringPrefix = "string: ";
    private static final String charPrefix = "char: ";
    private static final String referencePrefix = "reference: ";

    public static void log(Object message) {
        decorateString(referencePrefix, message);
    }

    public static void log(String message) {
        decorateString(stringPrefix, message);
    }

    public static void log(char message) {
       decorateString(charPrefix, message);
    }

    public static void log(boolean message) {
        decorateString(primitivePrefix, message);
    }

    public static void log(byte message) {
        decorateString(primitivePrefix, message);
    }

    public static void  log(Integer message) {
        decorateString(primitivePrefix, message);
    }

    private static void decorateString(String prefix, Object message) {
        System.out.println(prefix + message);
    }
}


