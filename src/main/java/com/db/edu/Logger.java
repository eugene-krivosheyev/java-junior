package com.db.edu;

public class Logger {
    public static final String PREFIX_PRIMITIVE = "primitive";
    public static final String PREFIX_CHAR = "char";
    public static final String PREFIX_STRING = "string";
    public static final String PREFIX_REFERENCE = "reference";

    private Logger() {

    }

    public static void log(int message) {
        System.out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(byte message) {
        System.out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(char message) {
        System.out.println(PREFIX_CHAR + ": " + message);
    }

    public static void log(String message) {
        System.out.println(PREFIX_STRING + ": " + message);
    }

    public static void log(boolean message) {
        System.out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(Object message) {
        System.out.println(PREFIX_REFERENCE + ": " + message);
    }
}