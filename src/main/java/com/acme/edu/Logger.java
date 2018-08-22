package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String CHAR = "char";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";

    public static void log(int message) {
        save(PRIMITIVE, Integer.toString(message));
    }

    public static void log(byte message) {
        save(PRIMITIVE, Byte.toString(message));
    }

    public static void log(char message) {
        save(CHAR, Character.toString(message));
    }

    public static void log(boolean message) {
        save(PRIMITIVE, Boolean.toString(message));
    }

    public static void log(String message) {
        save(STRING, message);
    }

    public static void log(Object message) {
        save(REFERENCE, message.toString());
    }

    private static void save(String type, String message) {
        System.out.println(type + ": " + message);
    }

}
