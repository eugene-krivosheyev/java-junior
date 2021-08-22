package com.db.education.app;

import java.util.Objects;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    public static void log(int message) {
        updateLastObject(message);
        accumulateInteger(message);
    }

    public static void log(byte message) {
        updateLastObject(message);
        accumulateByte(message);
    }

    public static void log(char message) {
        updateLastObject(message);
        writeToOutput(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        updateLastObject(message);
        accumulateString(message);
    }

    public static void log(boolean message) {
        updateLastObject(message);
        writeToOutput(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        updateLastObject(message);
        writeToOutput(OBJECT_PREFIX, message);
    }

    public static void flush() {
        if (lastObject instanceof Integer) {
            flushInteger();
        } else if (lastObject instanceof Byte) {
            flushByte();
        } else if (lastObject instanceof String) {
            flushString();
        }
    }

    private static Object lastObject;
    private static long accumulatedInteger = 0;
    private static int accumulatedByte = 0;
    private static String lastString = "";
    private static int countOfString = 0;

    private static void flushInteger() {
        writeToOutput(PRIMITIVE_PREFIX, accumulatedInteger);
        accumulatedInteger = 0;
    }

    private static void flushByte() {
        writeToOutput(PRIMITIVE_PREFIX, accumulatedByte);
        accumulatedByte = 0;
    }

    private static void flushString() {
        writeStringToOutput();
        countOfString = 0;
        lastString = "";
    }

    private static void writeToOutput(String prefix, Object message) {
        System.out.print(prefix + message + System.lineSeparator());
    }

    private static void writeStringToOutput() {
        String countString = "";
        if (countOfString > 1) {
            countString = " (x" + countOfString + ")";
        }
        writeToOutput(STRING_PREFIX, lastString + countString);
    }

    private static void accumulateString(String message) {
        if (Objects.equals(lastString, message)) {
            ++countOfString;
        } else {
            if (!lastString.isEmpty()) {
                writeStringToOutput();
            }

            lastString = message;
            countOfString = 1;
        }
    }

    private static void accumulateInteger(int number) {
        accumulatedInteger += number;
        if (accumulatedInteger > Integer.MAX_VALUE) {
            writeToOutput(PRIMITIVE_PREFIX, Integer.MAX_VALUE);
            accumulatedInteger -= Integer.MAX_VALUE;
        } else if (accumulatedInteger < Integer.MIN_VALUE) {
            writeToOutput(PRIMITIVE_PREFIX, Integer.MIN_VALUE);
            accumulatedInteger -= Integer.MIN_VALUE;
        }
    }

    private static void accumulateByte(byte number) {
        accumulatedByte += number;
        if (accumulatedByte > Byte.MAX_VALUE) {
            writeToOutput(PRIMITIVE_PREFIX, Byte.MAX_VALUE);
            accumulatedByte -= Byte.MAX_VALUE;
        } else if (accumulatedByte < Byte.MIN_VALUE) {
            writeToOutput(PRIMITIVE_PREFIX, Byte.MIN_VALUE);
            accumulatedByte -= Byte.MIN_VALUE;
        }
    }

    private static void updateLastObject(Object object) {
        if (lastObject != null &&
                !Objects.equals(lastObject.getClass().getName(), object.getClass().getName())) {
            flush();
        }
        lastObject = object;
    }
}
