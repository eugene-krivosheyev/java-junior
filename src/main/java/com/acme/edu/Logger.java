package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String CHAR = "char";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";
    private static final String SEPARATOR = ": ";

    public static void log(int message) {
        System.out.println(PRIMITIVE + SEPARATOR + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE + SEPARATOR + message);
    }

    public static void log(char message) {
        System.out.println(CHAR + SEPARATOR + message);
    }

    public static void log(String message) {
        System.out.println(STRING + SEPARATOR + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE + SEPARATOR + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE + SEPARATOR + message);
    }
}
