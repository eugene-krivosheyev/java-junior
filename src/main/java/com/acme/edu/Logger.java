package com.acme.edu;

public class Logger {
    public static void log(int message) {
        String decoratedMessage = PRIMITIVE + message;
        save(decoratedMessage);
    }

    public static void log(byte message) {
        String decoratedMessage = PRIMITIVE + message;
        save(decoratedMessage);
    }

    public static void log(char message) {
        String decoratedMessage = CHAR + message;
        save(decoratedMessage);
    }

    public static void log(String message) {
        String decoratedMessage = STRING + message;
        save(decoratedMessage);
    }

    public static void log(boolean message) {
        String decoratedMessage = PRIMITIVE + message;
        save(decoratedMessage);
    }

    public static void log(Object message) {
        String decoratedMessage = REFERENCE + message;
        save(decoratedMessage);
    }

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    private static void save(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

}
