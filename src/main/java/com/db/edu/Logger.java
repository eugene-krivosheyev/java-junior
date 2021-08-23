package com.db.edu;

import static java.lang.System.out;

public class Logger {
    public static final String PREFIX_PRIMITIVE = "primitive";
    public static final String PREFIX_CHAR = "char";
    public static final String PREFIX_STRING = "string";
    public static final String PREFIX_REFERENCE = "reference";
    private static int sum = 0;                                  //sum of integer sequence
    private static int maxValueCounter = 0;                      //number of overflows of the sum
    private static int integerSequenceLength = 0;
    private static int stringSequenceLength = 0;
    private static StringBuffer previousMessage = new StringBuffer();
    private static boolean messageIsSaved;

    private Logger() {

    }

    private static void accumulateLogs(int message) {
        integerSequenceLength++;
        sum += message;

        if (sum < 0) {
            maxValueCounter++;
            sum -= Integer.MAX_VALUE;
        }
    }

    private static void accumulateLogs(String message) {
        if (!previousMessage.toString().equals(message) && stringSequenceLength > 0) {
            out.println(PREFIX_STRING + ": " +  previousMessage + (stringSequenceLength > 1 ? " (x" + stringSequenceLength + ")" : ""));
            previousMessage.setLength(0);
            stringSequenceLength = 0;
            messageIsSaved = false;
        }

        if (!messageIsSaved) {
            previousMessage.append(message);
            messageIsSaved = true;
        }

        stringSequenceLength++;
    }

    private static void printOverflow(int maxValueCounter) {
        for (int i = 0; i < maxValueCounter; i++) {
            out.println(Integer.MAX_VALUE);
        }
    }

    private static void saveIntegersSum() {
        if (integerSequenceLength > 0) {
            printOverflow(maxValueCounter);
            out.println(PREFIX_PRIMITIVE + ": " + sum);
            sum = 0;
            maxValueCounter = 0;
            integerSequenceLength = 0;
        }
    }

    private static void saveStrings() {
        if (stringSequenceLength > 0) {
            out.println(PREFIX_STRING + ": " +  previousMessage + (stringSequenceLength > 1 ? " (x" + stringSequenceLength + ")" : ""));
            previousMessage.setLength(0);
            stringSequenceLength = 0;
            messageIsSaved = false;
        }
    }

    public static void stopAccumulate() {
        saveIntegersSum();
        saveStrings();
    }

    public static void log(int message) {
        saveStrings();
        accumulateLogs(message);
    }

    public static void log(byte message) {
        out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(char message) {
        out.println(PREFIX_CHAR + ": " + message);
    }

    public static void log(String message) {
        saveIntegersSum();
        accumulateLogs(message);
    }

    public static void log(boolean message) {
        out.println(PREFIX_PRIMITIVE + ": " + message);
    }

    public static void log(Object message) {
        out.println(PREFIX_REFERENCE + ": " + message);
    }
}