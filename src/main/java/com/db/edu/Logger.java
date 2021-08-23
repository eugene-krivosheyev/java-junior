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


    public static void flush() {
        if (type == null) return;
        if (type instanceof Integer) {
            flushNum(Integer.MAX_VALUE, Integer.MIN_VALUE);
        } else if (type instanceof Byte) {
            flushNum(Byte.MAX_VALUE, Byte.MIN_VALUE);
        } else if (type instanceof String) {
            flushString();
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

    public static void log(int ... message) {
        for (int value : message) {
            log(value);
        }
        flush();
    }

    public static void log(String ... message) {
        for (String value : message) {
            log(value);
        }
        flush();
    }

    private static void flushNum(int maxValue, int minValue) {
        long numResult = maxValue == Byte.MAX_VALUE ? byteResult : intResult;
        while (numResult > maxValue) {
            numResult -= maxValue;
            writeMessage(PRIMITIVE_PREFIX + maxValue);
        }
        while (numResult < minValue) {
            numResult -= minValue;
            writeMessage(PRIMITIVE_PREFIX + minValue);
        }
        writeMessage(PRIMITIVE_PREFIX + numResult);
        byteResult = 0;
        intResult = 0;
    }

    private static void flushString() {
        String strRes = STRING_PREFIX + stringResult;
        stringResult = "";
        if (stringCount > 1) {
            strRes += " (x" + stringCount + ")";
        }
        writeMessage(strRes);
        stringCount = 0;
    }

    private static void writeMessage(String s) {
        System.out.println(s);
    }
}