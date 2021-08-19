package com.acme.edu;

public class Logger {
    public static String PRIMITIVE_TYPE = "primitive: ";
    public static String CHAR_TYPE = "char: ";
    public static String STRING_TYPE = "string: ";
    public static String REFERENCE_TYPE = "reference: ";

    public static void log(int message) {
        System.out.println(PRIMITIVE_TYPE + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_TYPE + message);
    }

    public static void log(char message) {
        System.out.println(CHAR_TYPE + message);
    }

    public static void log(String message) {
        System.out.println(STRING_TYPE + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_TYPE + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_TYPE + message);
    }
}
