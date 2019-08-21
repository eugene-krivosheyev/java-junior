package com.acme.edu;

//Single line
/*
Multi-line comment
 */

import static com.acme.edu.Logger.*;

/**
 * JavaDoc comment
 * Class Logger has unnecessarily comment.
 * <strong>bold</strong>
 * @see java.lang.String#String()
 */

public class Logger {
    private static String HEADER_PRIMITIVE = "primitive: ";
    private static String HEADER_CHAR = "char: ";
    private static String HEADER_STRING = "string: ";
    private static String HEADER_REFERENCE = "reference: ";


    private static String generateLog(String header, String message) {
        return header + message;
    }

    private static void printLog(String header, String message) {
        System.out.println(generateLog(header, message));
    }

    public static void log(int message) {
        printLog(HEADER_PRIMITIVE, Integer.toString(message));
    }

    public static void log(byte message) {
        printLog(HEADER_PRIMITIVE, Byte.toString(message));
    }

    public static void log(char message) {
        printLog(HEADER_CHAR, Character.toString(message));
    }

    public static void log(String message) {
        printLog(HEADER_STRING, message);
    }

    public static void log(boolean message) {
        printLog(HEADER_PRIMITIVE, Boolean.toString(message));
    }

    public static void log(Object message) {
        printLog(HEADER_REFERENCE, message.toString());
    }

}