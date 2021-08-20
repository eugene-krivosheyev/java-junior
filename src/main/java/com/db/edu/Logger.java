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
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    private static MessageType currentType = null;
    private static int accumulatedInt;
    private static byte accumulatedByte;
    private static String accumulatedString;
    private static int stringCount = 1;

    public static void log(int message) {
        if (currentType != INTEGER) {
            flush();
            currentType = INTEGER;
            accumulatedInt = message;
        } else {
            long sum = abs((long) accumulatedInt + (long) message) - Integer.MAX_VALUE;

            if (sum > 0) {
                saveOutput(decorateOutput(PRIMITIVE_PREFIX, Integer.MAX_VALUE));
                accumulatedInt = (int) sum;
            } else {
                accumulatedInt += message;
            }
        }
    }

    public static void log(byte message) {
        if (currentType != BYTE) {
            flush();
            currentType = BYTE;
            accumulatedByte = message;
        } else {
            long sum = abs((long) accumulatedByte + (long) message) - Byte.MAX_VALUE;

            if (sum > 0) {
                saveOutput(decorateOutput(PRIMITIVE_PREFIX, Byte.MAX_VALUE));
                accumulatedByte = (byte) sum;
            } else {
                accumulatedByte += message;
            }
        }
    }

    public static void log(char message) {
        saveOutput(decorateOutput(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        if (currentType != STRING) {
            flush();
            currentType = STRING;
            accumulatedString = message;
        } else {
            if (accumulatedString.equals(message)) {
                stringCount++;
            } else {
                if (stringCount > 1) {
                    saveOutput(decorateOutput(STRING_PREFIX, accumulatedString, stringCount));
                } else {
                    saveOutput(decorateOutput(STRING_PREFIX, accumulatedString));
                }
                accumulatedString = message;
            }
        }
    }

    public static void log(boolean message) {
        saveOutput(decorateOutput(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message.toString());
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
                if (stringCount > 1) {
                    saveOutput(decorateOutput(STRING_PREFIX, accumulatedString, stringCount));
                } else {
                    saveOutput(decorateOutput(STRING_PREFIX, accumulatedString));
                }
                accumulatedString = null;
                stringCount = 1;
                break;
        }

        currentType = null;
    }
}