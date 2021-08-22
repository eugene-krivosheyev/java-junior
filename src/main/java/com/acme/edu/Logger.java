package com.acme.edu;

import java.util.Objects;

public class Logger {
    private static Class<?> prevClass;

    private static Long integerAccumulator = null;
    private static Integer byteAccumulator = null;
    private static String prevString;
    private static int stringCounter = 0;

    public static final String PRIMITIVE_PREFIX = "primitive:";
    public static final String STRING_PREFIX = "string:";
    public static final String CHAR_PREFIX = "char:";
    public static final String REFERENCE_PREFIX = "reference:";

    public static void log(int message) {
        initLogWriting(PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        initLogWriting(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        initLogWriting(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        initLogWriting(STRING_PREFIX, message);
    }

    public static void log(boolean message) {
        initLogWriting(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        initLogWriting(REFERENCE_PREFIX, message);
    }

    private static void initLogWriting(String prefix, Object message) {
        Class<?> currentClass = message.getClass();

        if (prevClass != currentClass) {
            flush();
        }

        if (currentClass.equals(String.class)) {
            logString(message.toString());
        } else if (currentClass.equals(Integer.class)) {
            logInteger((int) message);
        } else if (currentClass.equals(Byte.class)) {
            logByte((byte) message);
        } else {
            writeMessageToLog(prefix, message);
        }

        prevClass = currentClass;
    }

    private static void logString(String message) {

        if (Objects.equals(message, prevString)) {
            stringCounter++;
        } else {
            if (stringCounter != 0) {
                flush();
            }

            stringCounter = 1;
            prevString = message;
        }
    }

    private static void logInteger(int inputInteger) {
        integerAccumulator = integerAccumulator == null ?
                (long) inputInteger : integerAccumulator + inputInteger;

        if (integerAccumulator >= Integer.MAX_VALUE) {
            removeIntegerOverflow(Integer.MAX_VALUE);
        } else if (integerAccumulator <= Integer.MIN_VALUE) {
            removeIntegerOverflow(Integer.MIN_VALUE);
        }
    }

    private static void removeIntegerOverflow(int value) {
        writeMessageToLog(PRIMITIVE_PREFIX, value);
        integerAccumulator = integerAccumulator - value == 0 ? null : integerAccumulator - value;
    }

    private static void logByte(byte input) {
        if (byteAccumulator != null) {
            byteAccumulator += input;
        } else {
            byteAccumulator = (int) input;
        }

        if (byteAccumulator >= Byte.MAX_VALUE) {
            removeByteOverflow(Byte.MAX_VALUE);
        } else if (byteAccumulator <= Byte.MIN_VALUE) {
            removeByteOverflow(Byte.MIN_VALUE);
        }
    }

    private static void removeByteOverflow(int value) {
        writeMessageToLog(PRIMITIVE_PREFIX, value);
        byteAccumulator = byteAccumulator - value == 0 ? null : byteAccumulator - value;
    }

    public static void flush() {
        if (prevString != null) {
            if (stringCounter == 1) {
                writeMessageToLog(STRING_PREFIX, prevString);
            } else {
                writeMessageToLog(STRING_PREFIX, prevString, stringCounter);
            }

            prevString = null;
            stringCounter = 0;
        }

        if (integerAccumulator != null) {
            writeMessageToLog(PRIMITIVE_PREFIX, integerAccumulator);
            integerAccumulator = null;
        }

        if (byteAccumulator != null) {
            writeMessageToLog(PRIMITIVE_PREFIX, byteAccumulator);
            byteAccumulator = null;
        }
    }

    private static void writeMessageToLog(String prefix, Object message) {
        logToConsole(String.format("%s %s%n", prefix, message.toString()));
    }

    private static void writeMessageToLog(String prefix, Object message, int counter) {
        logToConsole(String.format("%s %s (x%d)%n", prefix, message.toString(), counter));
    }

    private static void logToConsole(String report) {
        System.out.print(report);
    }
}
