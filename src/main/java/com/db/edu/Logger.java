package com.db.edu;

import java.io.PrintStream;

public class Logger {

    private static final PrintStream OUT = System.out;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        OUT.println(PRIMITIVE_PREFIX+message);
    }

    public static void log(byte message) {
        OUT.println(PRIMITIVE_PREFIX+message);
    }

    public static void log(char message) {
        OUT.println(CHAR_PREFIX + message);
    }

    public static void log(boolean message) {
        OUT.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(String message) {
        OUT.println(STRING_PREFIX + message);
    }

    public static void log(Object message) {
        OUT.println(REFERENCE_PREFIX + message);
    }
}
