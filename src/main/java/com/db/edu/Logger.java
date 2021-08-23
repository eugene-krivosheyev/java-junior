package com.db.edu;

import java.util.Objects;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    //The sum of sequent ints and flag means, that sum was changed (for zero case)
    private static int sum = 0;
    private static int flagThereIsInteger = 0;

    //The value of repetitive string
    private static String bufString = null;

    //The number of repetitive strings
    private static int quantityString = 0;

    //The list of states
    private enum State {
        STRING,
        INT,
        BYTE,
        CHAR,
        BOOLEAN,
        OBJECT
    }

    //Current state
    private static State state;

    //Prints the result with some additions for Strings: number of repetitive strings
    private static <T> void printLog(String prefix, T message) {
        if (message instanceof String) {
            if (quantityString == 1) {
                System.out.println(prefix + message);
            } else {
                System.out.println(prefix + message + " (x" + quantityString + ")");
            }
            return;
        }
        System.out.println(prefix + message);
    }

    //Cleans the string buffer and int sum if the input type changes
    private static void flushBuffer(State inputType) {
        if (inputType != State.STRING) {
            if (state == State.STRING) {
                printLog(STRING_PREFIX, bufString);
                quantityString = 0;
                bufString = null;
            }
        } else if (inputType != State.INT){
            if (state == State.INT) {
                printLog(PRIMITIVE_PREFIX, sum);
                flagThereIsInteger = 0;
                sum = 0;
            }
        }
    }

    //Cleans the string buffer and int sum in the end
    public static void flusher() {
        if (!Objects.equals(bufString, null)) {
            printLog(STRING_PREFIX, bufString);
            bufString = null;
        }
        if (flagThereIsInteger == 1) {
            printLog(PRIMITIVE_PREFIX, sum );
            sum = 0;
            flagThereIsInteger = 0;
        }
    }

    public static void log(int message) {
        flushBuffer(State.INT);
        if (Integer.MAX_VALUE - message >= sum) {
            sum += message;
        } else {
            printLog(PRIMITIVE_PREFIX, sum);
            sum = message;
        }
        flagThereIsInteger = 1;
        state = State.INT;
    }

    public static void log(byte message) {
        flushBuffer(State.BYTE);
        printLog(PRIMITIVE_PREFIX, message);
        state = State.BYTE;
    }

    public static void log(char message) {
        flushBuffer(State.CHAR);
        printLog(CHAR_PREFIX, message);
        state = State.CHAR;
    }

    public static void log(String message) {
        flushBuffer(State.STRING);
        if (Objects.equals(bufString, null)) {
            bufString = message;
            quantityString = 1;
        } else if (Objects.equals(message, bufString)) {
            ++quantityString;
        } else {
            flushBuffer(State.INT);
            bufString = message;
            quantityString = 1;
        }
        state = State.STRING;
    }

    public static void log(boolean message) {
        flushBuffer(State.BOOLEAN);
        printLog(PRIMITIVE_PREFIX, message);
        state = State.BOOLEAN;
    }

    public static void log(Object message) {
        flushBuffer(State.OBJECT);
        printLog(REFERENCE_PREFIX, message);
        state = State.OBJECT;
    }
}
