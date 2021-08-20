package com.db.edu;

import java.util.Objects;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    private static int sum = 0;
    private static String previousString;
    private static int quantityString = 0;
    private static enum State {STRING, INT, BYTE};
//    private static boolean isStateByte;
//    private static boolean isStateString;


    private static <T> void printLog(String name, T message) {
        System.out.println(name + message);
    }

    private static void processLog(String prefix, String message) {
        if (Objects.equals(message, previousString)) {
            ++quantityString;
        } else {
            previousString = message;
            ++quantityString;
        }
    }

    private static void processLog(String prefix, int message) {
        if (Integer.MAX_VALUE - message >= sum) {
            sum += message;
        } else {
            printLog(prefix, sum);
            printLog(prefix, message);
            sum = 0;
        }

    }

    private static void processLog(String prefix, byte message) {

    }

    public static void log(int message) {
        printLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        printLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        printLog(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        printLog(STRING_PREFIX, message);
    }

    public static void log(boolean message) {
        printLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        printLog(REFERENCE_PREFIX, message);
    }
}
