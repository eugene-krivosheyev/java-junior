package com.db.edu;

import static com.db.edu.MessageType.*;
import static java.lang.Math.*;

enum MessageType {
    INTEGER,
    CHAR,
    BYTE,
    STRING
}

public class Logger {
    /**
     * Primitive prefix
     */
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    /**
     * Char prefix
     */
    public static final String CHAR_PREFIX = "char: ";
    /**
     * String prefix
     */
    public static final String STRING_PREFIX = "string: ";
    /**
     * Reference prefix
     */
    public static final String REFERENCE_PREFIX = "reference: ";

    /* ======== PRIVATE FIELDS ======== */
    private static MessageType currentType = null;
    private static int accumulatedInt;
    private static byte accumulatedByte;
    private static String accumulatedString;
    private static int stringCount = 1;

    /**
     * Logging Integer
     * @param message
     */
    public static void log(int message) {
        accumulatedInt = (int) accumulateNumber(INTEGER, accumulatedInt, message, Integer.MAX_VALUE);
    }

    /**
     * Logging Byte
     * @param message
     */
    public static void log(byte message) {
        accumulatedByte = (byte) accumulateNumber(BYTE, accumulatedByte, message, Byte.MAX_VALUE);
    }

    /**
     * Logging Character
     * @param message
     */
    public static void log(char message) {
        saveOutput(decorateOutput(CHAR_PREFIX, message));
    }

    /**
     * Logging String
     * @param message
     */
    public static void log(String message) {
        if (currentType != STRING) {
            flushAndSetType(STRING);
            accumulatedString = message;
        } else {
            if (accumulatedString.equals(message)) {
                stringCount++;
            } else {
                saveOutputAndCount(STRING_PREFIX, accumulatedString, stringCount);
                accumulatedString = message;
            }
        }
    }

    /**
     * Logging Boolean
     * @param message
     */
    public static void log(boolean message) {
        saveOutput(decorateOutput(PRIMITIVE_PREFIX, message));
    }

    /**
     * Logging object reference
     * @param message
     */
    public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message.toString());
    }

    /**
     * Save output and reset accumulated values
     */
    public static void flush() {
        if (currentType == null) return;

        switch (currentType) {
            case INTEGER:
                saveOutput(decorateOutput(PRIMITIVE_PREFIX, accumulatedInt));
                accumulatedInt = 0;
                break;
            case BYTE:
                saveOutput(decorateOutput(PRIMITIVE_PREFIX, accumulatedByte));
                accumulatedByte = 0;
                break;
            case STRING:
                saveOutputAndCount(STRING_PREFIX, accumulatedString, stringCount);
                accumulatedString = null;
                stringCount = 1;
                break;
            default:
                return;
        }

        currentType = null;
    }


    /* ======== PRIVATE METHODS ======== */
    private static void flushAndSetType(MessageType type) {
        flush();
        currentType = type;
    }

    private static long accumulateNumber(MessageType type, long accumulatedValue, long message, long maxValue) {
        if (currentType != type) {
            flushAndSetType(type);
            accumulatedValue = message;
        } else {
            accumulatedValue = modMaxValue(accumulatedValue, message, maxValue);
        }
        return accumulatedValue;
    }

    private static long modMaxValue(long accumulatedValue, long message, long max) {
        long sum = abs( accumulatedValue + message) - max;
        if (sum > 0) {
            saveOutput(decorateOutput(PRIMITIVE_PREFIX, max));
            accumulatedValue = sum;
        } else {
            accumulatedValue += message;
        }

        return accumulatedValue;
    }

    // TODO: implement for char
    private static void saveOutputAndCount(String prefix, String accumulatedString, int count) {
        if (stringCount > 1) {
            saveOutput(decorateOutput(prefix, accumulatedString, count));
        } else {
            saveOutput(decorateOutput(prefix, accumulatedString));
        }
    }

    private static String decorateOutput(String prefix, Object message) {
        return prefix + message + System.lineSeparator();
    }

    private static String decorateOutput(String prefix, Object message, int stringCount) {
        return prefix + message + " (x" + stringCount + ")" + System.lineSeparator();
    }

    private static void saveOutput(String decoratedMessage) {
        System.out.print(decoratedMessage);
    }
}