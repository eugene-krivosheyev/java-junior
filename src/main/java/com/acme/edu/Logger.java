package com.acme.edu;

public class Logger {
    private static String PRIMITIVE = "primitive: ";
    private static String CHAR = "char: ";
    private static String STRING = "string: ";
    private static String REFERENCE = "reference: ";

    private static void print(String prefix, Object postfix) { System.out.println(prefix + postfix); }

    public static void log(int message) { print(PRIMITIVE, message); }

    public static void log(byte message) {
        print(PRIMITIVE, message);
    }

    public static void log(char message) {
        print(CHAR, message);
    }

    public static void log(String message) {
        print(STRING, message);
    }

    public static void log(boolean message) {
        print(PRIMITIVE, message);
    }

    public static void log(Object message) {
        print(REFERENCE, message);
    }
}
