package com.db.edu;

import java.util.Objects;

public class Logger {

    /**
     * The list of prefixes
     */
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static int sum = 0;
    private static int flagThereIsInteger = 0;
    private static String bufString = null;
    private static int quantityString = 0;
    private static Controller controller;

    private enum State {
        STRING,
        INT,
        BYTE,
        CHAR,
        BOOLEAN,
        OBJECT
    }
    private static State state;

    private Logger() {
    }

    private static void printLog(String message) {
        System.out.println(message);
    }

    private static void flushInt() {
        if (state == State.INT) {
            printLog(PRIMITIVE_PREFIX + sum);
            flagThereIsInteger = 0;
            sum = 0;
        }
    }

    private static void flushString() {
        if (state == State.STRING) {
            if (quantityString == 1) {
                printLog(STRING_PREFIX + bufString);
            } else {
                printLog(STRING_PREFIX + bufString + " (x" + quantityString + ")");
            }
            quantityString = 0;
            bufString = null;
        }
    }

    /**
     * Cleans the string buffer and int sum in the end of logs
     */
    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));

        /*if (message >= 0) {
            if (Integer.MAX_VALUE - message >= sum) {
                sum += message;
            } else {
                printLog(PRIMITIVE_PREFIX + Integer.MAX_VALUE);
                sum = message - (Integer.MAX_VALUE - sum);
            }
        } else {
            if (Integer.MIN_VALUE - message <= sum) {
                sum += message;
            } else {
                printLog(PRIMITIVE_PREFIX + Integer.MIN_VALUE);
                sum = message - (Integer.MIN_VALUE - sum);
            }
        }*/
    }

    public static void log(Integer ... args) {
        for (int x : args) {
            log(x);
        }
    }

    public static void log(byte message) {
        flushString();
        flushInt();
        printLog(PRIMITIVE_PREFIX + message);
        state = State.BYTE;
    }

    public static void log(char message) {
        flushString();
        flushInt();
        printLog(CHAR_PREFIX + message);
        state = State.CHAR;
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(String ... args) {
        for (String x : args) {
            log(x);
        }
    }

    public static void log(boolean message) {
        flushString();
        flushInt();
        printLog(PRIMITIVE_PREFIX + message);
        state = State.BOOLEAN;
    }

    public static void log(Object message) {
        flushString();
        flushInt();
        printLog(REFERENCE_PREFIX + message);
        state = State.OBJECT;
    }
}
