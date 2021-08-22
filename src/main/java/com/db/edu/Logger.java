package com.db.edu;

import java.util.Objects;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    private static int sum = 0;
    private static String bufString = "";
    private static int quantityString = 0;
    private enum State {STRING, INT, BYTE, CHAR, BOOLEAN, OBJECT}
    private static State state;

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

    private static void flushBuffer(State inputType) {
        if (inputType != State.STRING) {
            if (state == State.STRING) {
                printLog(STRING_PREFIX, bufString);
                quantityString = 0;
                bufString = "";
            }
        } else if (inputType != State.INT){
            if (state == State.INT) {
                printLog(PRIMITIVE_PREFIX, sum);
                sum = 0;
            }
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
        if (Objects.equals(bufString, "")) {
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
