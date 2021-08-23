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

    /**
     * The sum of sequent ints and flag means, that sum was changed (for zero case)
     */
    private static int sum = 0;
    private static int flagThereIsInteger = 0;

    /**
     * The value of repetitive string
     */
    private static String bufString = null;

    /**
     * The number of repetitive strings
     */
    private static int quantityString = 0;

    /**
     * The list of states
     */
    private enum State {
        STRING,
        INT,
        BYTE,
        CHAR,
        BOOLEAN,
        OBJECT
    }

    /**
     * Current state
     */
    private static State state;

    /**
     * Prints the message
     * @param message
     */
    private static void printLog(String message) {
        System.out.println(message);
    }

    /**
     * Cleans & prints buffer of ints if input type changes
     * @see #printLog(String)
     */
    private static void flushInt() {
        if (state == State.INT) {
            printLog(PRIMITIVE_PREFIX + sum);
            flagThereIsInteger = 0;
            sum = 0;
        }
    }

    /**
     * Cleans & prints buffer of Strings if input type changes
     * @see #printLog(String)
     */
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
        if (!Objects.equals(bufString, null)) {
            flushString();
        }
        if (flagThereIsInteger == 1) {
            flushInt();
        }
    }

    public static void log(int message) {
        flushString();
        flagThereIsInteger = 1;
        if (message >= 0) {
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
        }
        state = State.INT;
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
        flushInt();
        if (Objects.equals(bufString, null)) {
            bufString = message;
            quantityString = 1;
        } else if (Objects.equals(message, bufString)) {
            ++quantityString;
        } else {
            flushString();
            bufString = message;
            quantityString = 1;
        }
        state = State.STRING;
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
