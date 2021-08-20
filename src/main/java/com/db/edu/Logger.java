package com.db.edu;

import static java.lang.System.out;

public class Logger {
    public static final String PREFIX_PRIMITIVE = "primitive";
    public static final String PREFIX_CHAR = "char";
    public static final String PREFIX_STRING = "string";
    public static final String PREFIX_REFERENCE = "reference";
    private static int sum = 0;              //sum of integer sequence
    private static boolean printIsNeeded;   //
    private static boolean previousLogIsAnotherType;
    private static int maxValueCounter = 0;
    private static int sequenceLength = 0;   //
    private static boolean isInteger;
    private static boolean isString;
    private static String message;

    private Logger() {

    }

    public static void accumulateLogs(int message) {
        sequenceLength++;
        sum += message;

        if (sum < 0) {
            maxValueCounter++;
            sum -= Integer.MAX_VALUE;
        }
    }

    public static void stopAccumulate() {
        if (previousLogIsAnotherType) {
            if (isInteger) {
                out.println(sum);
            } else {
                out.println(message);
            }
        }
    }

    private static void printOverflow(int maxValueCounter) {
        for (int i = 0; i < maxValueCounter; i++) {
            out.println(Integer.MAX_VALUE);
        }
    }

    public static void log(int message) {
//        previousLogIsAnotherType = false;
        accumulateLogs(message);
//        if (previousLogIsAnotherType) {
//            printOverflow(maxValueCounter);
//            out.println(PREFIX_PRIMITIVE + ": " + sum);
//            sum = 0;
//            maxValueCounter = 0;
//        }
    }

    public static void log(byte message) {
        out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(char message) {
        out.println(PREFIX_CHAR + ": " + message);
    }

    public static void log(String message) {
//        previousLogIsAnotherType = true;
        if (sequenceLength > 0) {
            printOverflow(maxValueCounter);
            out.println(PREFIX_PRIMITIVE + ": " + sum);
            sum = 0;
            maxValueCounter = 0;
            sequenceLength = 0;
        }
        out.println(PREFIX_STRING + ": " + message);
    }

    public static void log(boolean message) {
        out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(Object message) {
        out.println(PREFIX_REFERENCE + ": " + message);
    }
}