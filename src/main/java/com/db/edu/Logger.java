package com.db.edu;


public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";
    private static long intResult;
    private static int byteResult;
    private static String stringResult;
    private static int stringCount;
    private static Object type;

    private static void intFlush() {
        while (intResult > Integer.MAX_VALUE) {
            intResult -= Integer.MAX_VALUE;
            writeMessage(PRIMITIVE_PREFIX + Integer.MAX_VALUE);
        }
        while (intResult < Integer.MIN_VALUE) {
            intResult -= Integer.MIN_VALUE;
            writeMessage(PRIMITIVE_PREFIX + Integer.MIN_VALUE);
        }
        writeMessage(PRIMITIVE_PREFIX + intResult);
        intResult = 0;
    }

    private static void byteFlush() {
        while (byteResult > Byte.MAX_VALUE) {
            byteResult -= Byte.MAX_VALUE;
            writeMessage(PRIMITIVE_PREFIX + Byte.MAX_VALUE);
        }
        while (byteResult < Byte.MIN_VALUE) {
            byteResult -= Byte.MIN_VALUE;
            writeMessage(PRIMITIVE_PREFIX + Byte.MIN_VALUE);
        }
        writeMessage(PRIMITIVE_PREFIX + byteResult);
        byteResult = 0;
    }

    private static void stringFlush() {
        String strRes = STRING_PREFIX + stringResult;
        stringResult = "";
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        writeMessage(strRes);
        stringCount = 0;
    }

    public static void flush() {
        if (type == null) return;
        if (type instanceof Integer) {
            intFlush();
        } else if (type instanceof Byte) {
            byteFlush();
        } else if (type instanceof String) {
            stringFlush();
        }
    }

    public static void log(int message) {
        if (!(type instanceof Integer)) {
            flush();
            type = message;
        }
        intResult += message;
    }

    public static void log(byte message) {
        if (!(type instanceof Byte)) {
            flush();
            type = message;
        }
        byteResult += message;
    }

    public static void log(boolean message) {
        writeMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        writeMessage(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (!(type instanceof String)) {
            flush();
            type = message;
        } else if (!message.equals(stringResult)) {
            flush();
        }
        stringResult = message;
        stringCount++;
    }

    public static void log(Object message) {
        writeMessage(OBJECT_PREFIX + message);
    }

    private static void writeMessage(String s) {
        System.out.println(s);
    }
}