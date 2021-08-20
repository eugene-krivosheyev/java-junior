package com.acme.edu;

import java.util.Objects;

public class Logger {
    private static Class<?> prevClass;

    private static Long integerAccumulator = null;
    private static String prevString;
    private static int stringCounter = 0;

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    public static void log(int message) {
        writeLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        writeLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        writeLog(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        writeLog(STRING_PREFIX, message);
    }

    public static void log(boolean message) {
        writeLog(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        writeLog(REFERENCE_PREFIX, message);
    }

    private static void writeLog(String prefix, Object message) {
        Class<?> currentClass = message.getClass();

        if (prevClass != currentClass) {
            closeLog();
        }

        if (currentClass.equals(String.class)) {
            logString(message.toString());
        } else if (currentClass.equals(Integer.class)) {
            logInteger((int) message);
        } else {
            writeLogToConsole(prefix, message);
        }

        prevClass = currentClass;
    }

    private static void logString(String message) {
        if (Objects.equals(message, prevString)) {
            stringCounter++;
        } else if (!Objects.equals(message, prevString) && stringCounter == 0) {
            stringCounter = 1;
            prevString = message;
        } else {
            closeLog();
            stringCounter = 1;
            prevString = message;
        }
    }

    private static void logInteger(int inputInteger) {
        if (integerAccumulator != null) {
            integerAccumulator += inputInteger;
        } else {
            integerAccumulator = (long) inputInteger;
        }

        if (integerAccumulator >= Integer.MAX_VALUE) {
            writeLogToConsole(PRIMITIVE_PREFIX, Integer.MAX_VALUE);
            integerAccumulator = integerAccumulator - Integer.MAX_VALUE == 0 ? null : integerAccumulator - Integer.MAX_VALUE;
        } else if (integerAccumulator <= Integer.MIN_VALUE) {
            writeLogToConsole(PRIMITIVE_PREFIX, Integer.MIN_VALUE);
            integerAccumulator = integerAccumulator - Integer.MIN_VALUE == 0 ? null : integerAccumulator - Integer.MIN_VALUE;
        }
    }

    public static void closeLog() {
        if (prevString != null) {
            if (stringCounter == 1) {
                writeLogToConsole(STRING_PREFIX, prevString);
            } else {
                writeLogToConsole(STRING_PREFIX, prevString, stringCounter);
            }

            prevString = null;
            stringCounter = 0;
        }

        if (integerAccumulator != null) {
            writeLogToConsole(STRING_PREFIX, integerAccumulator);
            integerAccumulator = null;
        }
    }

    private static void writeLogToConsole(String prefix, Object message) {
        System.out.println(prefix + message);
    }

    private static void writeLogToConsole(String prefix, Object message, int counter) {
        System.out.printf("%s%s (x%d)%n", prefix, message, counter);
    }
}
