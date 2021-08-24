package com.db.edu;

import static java.lang.System.out;

public class Logger {
    public static final String PREFIX_PRIMITIVE = "primitive";
    public static final String PREFIX_CHAR = "char";
    public static final String PREFIX_STRING = "string";
    public static final String PREFIX_REFERENCE = "reference";
    public static final String PREFIX_PRIMITIVES_ARRAY = "primitives array";
    public static final String LEFT_BRACKET = "{";
    public static final String RIGHT_BRACKET = "}";
    public static final String COLON = ": ";

    private static int sum = 0;                                  //sum of integer sequence
    private static int maxValueCounter = 0;                      //number of overflows of the sum
    private static int integerSequenceLength = 0;
    private static int stringSequenceLength = 0;
    private static StringBuffer previousMessage = new StringBuffer();
    private static boolean messageIsSaved;

    private Logger() {

    }

    public static void close() {
        saveIntegersSum();
        saveStrings();
    }

    public static void log(int message) {
        saveStrings();
        accumulateLogs(message);
    }

    public static void log(int... message) {
        saveStrings();
        for (int value : message) {
            accumulateLogs(value);
        }
    }

    public static void log(byte message) {
        printDecoratedMessage(PREFIX_PRIMITIVE, message);
    }

    public static void log(char message) {
        printDecoratedMessage(PREFIX_CHAR, message);
    }

    public static void log(String message) {
        saveIntegersSum();
        accumulateLogs(message);
    }

    public static void log(String... message) {
        saveIntegersSum();
        for (String messagePart : message) {
            accumulateLogs(messagePart);
        }
    }

    public static void log(boolean message) {
        printDecoratedMessage(PREFIX_PRIMITIVE, message);
    }

    public static void log(Object message) {
        printDecoratedMessage(PREFIX_REFERENCE, message);
    }

//    public static void log(int[] message) {
//        StringBuilder arrayValues = new StringBuilder();
//
//        for (int i = 0; i < message.length - 1; i++) {
//            arrayValues.append(message[i]);
//            arrayValues.append(", ");
//        }
//
//        arrayValues.append(message[message.length - 1]);
//        String array = LEFT_BRACKET + arrayValues + RIGHT_BRACKET;
//        out.println(PREFIX_PRIMITIVES_ARRAY + COLON + array);
//    }

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
            printDecoratedMessageWithDuplricateCounting(PREFIX_STRING, stringSequenceLength);
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
            printDecoratedMessage("", Integer.MAX_VALUE);
        }
    }

    private static void saveIntegersSum() {
        if (integerSequenceLength > 0) {
            printOverflow(maxValueCounter);
            printDecoratedMessage(PREFIX_PRIMITIVE, sum);
            sum = 0;
            maxValueCounter = 0;
            integerSequenceLength = 0;
        }
    }

    private static void saveStrings() {
        if (stringSequenceLength > 0) {
            printDecoratedMessageWithDuplricateCounting(PREFIX_STRING, stringSequenceLength);
            previousMessage.setLength(0);
            stringSequenceLength = 0;
            messageIsSaved = false;
        }
    }

    private static void printDecoratedMessage(String prefix, int message) {
        out.println(prefix + ": " + message);
    }

    private static void printDecoratedMessage(String prefix, byte message) {
        out.println(prefix + ": " + message);
    }

    private static void printDecoratedMessage(String prefix, char message) {
        out.println(prefix + ": " + message);
    }

    private static void printDecoratedMessage(String prefix, String message) {
        out.println(prefix + ": " + message);
    }

    private static void printDecoratedMessage(String prefix, boolean message) {
        out.println(prefix + ": " + message);
    }

    private static void printDecoratedMessage(String prefix, Object message) {
        out.println(prefix + ": " + message);
    }

    private static void printDecoratedMessageWithDuplricateCounting(String prefix, int counter) {
        out.println(prefix + ": " +  previousMessage + (counter > 1 ? " (x" + counter + ")" : ""));
    }
}