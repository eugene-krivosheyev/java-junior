package com.acme.edu;

public class Logger {
    private static String PRIMITIVE_POSTFIX = "primitive: ";
    private static String CHAR_POSTFIX = "char: ";
    private static String STRING_POSTFIX = "string: ";
    private static String REFERENCE_POSTFIX = "reference: ";

    public static void log(int message) {
        System.out.println(PRIMITIVE_POSTFIX + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_POSTFIX + message);
    }

    public static void log(char message) {
        System.out.println(CHAR_POSTFIX + message);
    }

    public static void log(String message) {
        System.out.println(STRING_POSTFIX + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_POSTFIX + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_POSTFIX + message);
    }
}
