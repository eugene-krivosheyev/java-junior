package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    private static String final_log = "";

    private static void print(String prefix, Object postfix) {
        final_log = final_log + (prefix + postfix) + System.lineSeparator();
    }

    public static void flush() {
        localFlush();
        System.out.print(final_log);
        final_log = "";
    }

    private static void localFlush() {
        if (previousIsInt)
            print(PRIMITIVE, primitiveSumInt);
        previousIsInt = false;
        primitiveSumInt = 0;
    }


    private static long primitiveSumInt = 0;
    private static boolean previousIsInt = false;

    public static void log(int message) {
        previousIsInt = true;
        primitiveSumInt += message;
    }

    public static void log(byte message) {
        localFlush();
        print(PRIMITIVE, message);
    }

    public static void log(char message) {
        localFlush();
        print(CHAR, message);
    }

    public static void log(String message) {
        localFlush();
        print(STRING, message);
    }

    public static void log(boolean message) {
        localFlush();
        print(PRIMITIVE, message);
    }

    public static void log(Object message) {
        localFlush();
        print(REFERENCE, message);
    }
}
