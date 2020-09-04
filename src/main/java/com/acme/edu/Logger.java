package com.acme.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0.2
 */
public class Logger {

    static String logMessage;
    static List<Object> listOfLog = new ArrayList<>();

    static final String CHAR_PREFIX = "char: ";
    static final String STRING_PREFIX = "string: ";
    static final String REFERENCE_PREFIX = "reference: ";
    static final String PRIMITIVE_PREFIX = "primitive: ";

    private static void writeMessage() {
        System.out.println(logMessage);
    }

    /**
     * @param  message  an integer value to be logged
     */
    public static void log(int message) {
        listOfLog.add(message);
    }

    public static void log(byte message) {
        listOfLog.add(message);
    }

    public static void log(boolean message) {
        logMessage = PRIMITIVE_PREFIX + message;
        writeMessage();
    }

    public static void log(char message) {
        logMessage = CHAR_PREFIX + message;
        writeMessage();
    }

    public static void log(String message) {
        listOfLog.add(message);
    }

    public static void log(Object message) {
        logMessage = REFERENCE_PREFIX + message;
        writeMessage();
    }

    public static void flushStart() {
        Object firstToLog = listOfLog.get(0);

        if (firstToLog instanceof Integer) {
            flushEnd(PRIMITIVE_PREFIX, sumInt());
        } else if (firstToLog instanceof Byte) {
            flushEnd(PRIMITIVE_PREFIX, sumByte());
        } else if (firstToLog instanceof String) {
            flushEnd(STRING_PREFIX, firstToLog);
        }

        listOfLog.clear();
    }

    static void flushEnd(String prefix, Object flushResult) {
        logMessage = prefix + flushResult;
        writeMessage();
    }

    static int sumInt() {
        int resultIntSum = 0;
        for (Object currentValue : listOfLog) {
            if (Integer.MAX_VALUE - resultIntSum < (int) currentValue) {
                resultIntSum = (int) currentValue - (Integer.MAX_VALUE - resultIntSum);
                flushEnd(PRIMITIVE_PREFIX, Integer.MAX_VALUE);
            } else {
                resultIntSum += (int) currentValue;
            }
        }
        return resultIntSum;
    }

    static byte sumByte() {
        byte resultByteSum = 0;
        for (Object currentValue : listOfLog) {
            if (Byte.MAX_VALUE - resultByteSum < (byte) currentValue) {
                resultByteSum = (byte) ((byte) currentValue - (Byte.MAX_VALUE - resultByteSum));
                flushEnd(PRIMITIVE_PREFIX, Byte.MAX_VALUE);
            } else {
                resultByteSum += (byte) currentValue;
            }
        }
        return resultByteSum;
    }
}