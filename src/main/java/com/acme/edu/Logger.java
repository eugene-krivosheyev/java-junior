package com.acme.edu;

public class Logger {
    private static SuperConsoleSaver saver;
    private SuperAccumulator accumulator;
    private static Command currentState = null;

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";

    /*public static void log(int message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }*/

    public static void log(byte message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        System.out.println(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        System.out.println(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    /*public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message);
    }*/
}
