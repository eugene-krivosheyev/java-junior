package com.acme.edu;

public class Logger {

    public static int INT_BUFFER = 0;
    public static int BYTE_BUFFER = 0;
    public static int STRING_BUFFER = 0;
    public static String PREVIOUS_TYPE = "";
    public static String PREVIOUS_STRING = "";
    public static String PREVIOUS_MESSAGE = "";
    public static String PRIMITIVE_PREFIX = "primitive: ";
    public static String CHAR_PREFIX = "char: ";
    public static String STRING_PREFIX = "string: ";
    public static String REFERENCE_PREFIX = "reference: ";
    public static String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";

    public static void log(int message) {
        if (Integer.MAX_VALUE - message < INT_BUFFER) {
            flushBuffers();
        }
        INT_BUFFER += message;
        if (!PREVIOUS_TYPE.equals(getClassName(message))) {
            flushBuffers();
        }
        PREVIOUS_TYPE = getClassName(message);
    }

    public static void log(byte message) {
        if (Byte.MAX_VALUE - message < BYTE_BUFFER) {
            flushBuffers();
        }
        BYTE_BUFFER += message;
        if (!PREVIOUS_TYPE.equals(getClassName(message))) {
            flushBuffers();
        }
        PREVIOUS_TYPE = getClassName(message);
    }

    public static void log(char message) {
        printLogMessage(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (!PREVIOUS_TYPE.equals(getClassName(message)) || !PREVIOUS_STRING.equals(message)) {
            flushBuffers();
        }
        if (PREVIOUS_STRING.equals(message)) {
            STRING_BUFFER += 1;
        }
        PREVIOUS_TYPE = getClassName(message);
        if (STRING_BUFFER == 0) {
            PREVIOUS_STRING = message;
            PREVIOUS_MESSAGE = message;
            STRING_BUFFER++;
        }
    }

    public static void log(boolean message) {
        printLogMessage(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printLogMessage(REFERENCE_PREFIX + message);
    }

    public static void log(int[] arrayMessage) {
        StringBuilder arrayElementsToPrint = new StringBuilder();
        for (int i = 0; i < arrayMessage.length - 1; i++) {
            arrayElementsToPrint.append(arrayMessage[i] + ", ");
        }
        arrayElementsToPrint.append(arrayMessage[arrayMessage.length - 1]);
        System.out.println(PRIMITIVES_ARRAY_PREFIX + "{" + arrayElementsToPrint + "}");
    }

    public static void printLogMessage(Object message) {
        System.out.println(message.toString());
    }

    public static void flushBuffers() {
        switch (PREVIOUS_TYPE) {
            case "String":
                if (STRING_BUFFER > 1) {
                    printLogMessage(STRING_PREFIX + PREVIOUS_STRING + " (x" + STRING_BUFFER + ")");
                } else
                    printLogMessage(STRING_PREFIX + PREVIOUS_STRING);
                flushString();
                break;
            case "Integer":
                printLogMessage(PRIMITIVE_PREFIX + INT_BUFFER);
                INT_BUFFER = 0;
                break;
            case "Byte":
                printLogMessage(PRIMITIVE_PREFIX + BYTE_BUFFER);
                BYTE_BUFFER = 0;
                break;
        }
    }

    public static void flushString() {
        STRING_BUFFER = 0;
        PREVIOUS_STRING = "";
        PREVIOUS_MESSAGE = "";
    }

    public static String getClassName(Object object) {
        return object.getClass().getSimpleName();
    }

}
