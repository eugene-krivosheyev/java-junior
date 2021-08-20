package com.db.education.app;

import java.util.Objects;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    private enum Type {
        BOOLEAN_TYPE,
        BYTE_TYPE,
        CHARACTER_TYPE,
        INTEGER_TYPE,
        OBJECT_TYPE,
        STRING_TYPE,
        NO_TYPE
    }

    private static String BUFFER = "";
    private static Type PREV_TYPE = Type.NO_TYPE;
    private static long ACCUMULATED_INT = 0;
    private static int ACCUMULATED_BYTE = 0;
    private static String LAST_STRING = "";
    private static int COUNT_OF_STR = 0;

    public static void log(int message) {
        updatePrevType(Type.INTEGER_TYPE);
        accumulateInteger(message);
    }

    public static void log(byte message) {
        updatePrevType(Type.BYTE_TYPE);
        appendToBuffer(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        updatePrevType(Type.CHARACTER_TYPE);
        appendToBuffer(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        updatePrevType(Type.STRING_TYPE);
        processStringMessage(message);
    }


    public static void log(boolean message) {
        updatePrevType(Type.BOOLEAN_TYPE);
        appendToBuffer(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        updatePrevType(Type.OBJECT_TYPE);
        appendToBuffer(OBJECT_PREFIX, message);
    }

    public static void flush() {
        finalizeBuffer();
        writeBufferToOutput();
        resetBuffer();
    }

    private static void finalizeBuffer() {
        if (Type.STRING_TYPE.equals(PREV_TYPE)) appendStringToBuffer();
        if (Type.INTEGER_TYPE.equals(PREV_TYPE)) appendToBuffer(PRIMITIVE_PREFIX, ACCUMULATED_INT);
        if (Type.BYTE_TYPE.equals(PREV_TYPE)) appendToBuffer(PRIMITIVE_PREFIX, ACCUMULATED_BYTE);
    }

    private static void writeBufferToOutput() {
        System.out.print(BUFFER);
    }

    private static void resetBuffer() {
        BUFFER = "";
        LAST_STRING = "";
        PREV_TYPE = Type.NO_TYPE;
        ACCUMULATED_BYTE = 0;
        ACCUMULATED_INT = 0;
    }

    private static void processStringMessage(String message) {
        if (LAST_STRING.equals(message)) {
            ++COUNT_OF_STR;
        } else {
            if (!LAST_STRING.isEmpty()) {
                appendStringToBuffer();
            }
            LAST_STRING = message;
            COUNT_OF_STR = 1;
        }
    }

    private static void accumulateInteger(int number) {
        ACCUMULATED_INT += number;
        if (ACCUMULATED_INT > Integer.MAX_VALUE) {
            appendToBuffer(PRIMITIVE_PREFIX, Integer.MAX_VALUE);
            ACCUMULATED_INT -= Integer.MAX_VALUE;
        } else if (ACCUMULATED_INT < Integer.MIN_VALUE) {
            appendToBuffer(PRIMITIVE_PREFIX, Integer.MIN_VALUE);
            ACCUMULATED_INT -= Integer.MIN_VALUE;
        }
    }

    private static void accumulateByte(byte number) {
        ACCUMULATED_BYTE += number;
        if (ACCUMULATED_BYTE > Byte.MAX_VALUE) {
            appendToBuffer(PRIMITIVE_PREFIX, Byte.MAX_VALUE);
            ACCUMULATED_BYTE -= Byte.MAX_VALUE;
        } else if (ACCUMULATED_BYTE < Byte.MIN_VALUE) {
            appendToBuffer(PRIMITIVE_PREFIX, Byte.MIN_VALUE);
            ACCUMULATED_BYTE -= Byte.MIN_VALUE;
        }
    }

    private static void appendToBuffer(String prefix, Object message) {
        BUFFER += prefix + message + System.lineSeparator();
    }

    private static void appendStringToBuffer() {
        String count = "";
        if (COUNT_OF_STR > 1) {
            count = " (x" + COUNT_OF_STR + ")";
        }
        appendToBuffer(STRING_PREFIX, LAST_STRING + count);
        LAST_STRING = "";
        COUNT_OF_STR = 0;
    }

    private static void updatePrevType(Type currentType) {
        if (Objects.equals(PREV_TYPE, currentType)) return;
        if (Objects.equals(PREV_TYPE, Type.INTEGER_TYPE)) {
            appendToBuffer(PRIMITIVE_PREFIX, ACCUMULATED_INT);
            ACCUMULATED_INT = 0;
        } else if (Objects.equals(PREV_TYPE, Type.STRING_TYPE)) {
            appendStringToBuffer();
        }
        PREV_TYPE = currentType;
    }
}
