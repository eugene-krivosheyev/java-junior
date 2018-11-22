package com.acme.edu;


public class TypeSafeLogger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String STRING_PREFIX = "string: ";

    private static final String INT_TYPE = "int";
    private static final String BYTE_TYPE = "byte";
    private static final String CHAR_TYPE = "char";
    private static final String BOOLEAN_TYPE = "boolean";
    private static final String REFERENCE_TYPE = "reference";
    private static final String STRING_TYPE = "string";


    private static String currentString = "";
    private static int currentStringCount = 0;
    private static int currentInt = 0;
    private static byte currentByte = (byte)0;
    private static char currentChar = ' ';
    private static boolean currentBoolean = false;
    private static Object currentReference = false;

    private static String lastType = "";
    private static String decoratedMessage = "";

    /**
     * OCP
     */

    public static void log(int message) {
        flushIfTypeChanged(INT_TYPE);
        flushIfOverflow(message);
        setCurrentState(message);
        updateDecoratedMessage();
    }

    public static void log(byte message) {
        flushIfTypeChanged(BYTE_TYPE);
        flushIfOverflow(message);
        setCurrentState(message);
        updateDecoratedMessage();
    }

    public static void log(char message) {
        flushIfTypeChanged(CHAR_TYPE);
        setCurrentState(message);
        updateDecoratedMessage();
    }

    public static void log(boolean message) {
        flushIfTypeChanged(BOOLEAN_TYPE);
        setCurrentState(message);
        updateDecoratedMessage();
    }

    public static void log(String message) {
        flushIfTypeChanged(STRING_TYPE);
        flushIfStringChanged(message);
        setCurrentState(message);
        updateDecoratedMessage();
    }

    public static void log(Object message) {
        flushIfTypeChanged(REFERENCE_TYPE);
        setCurrentState(message);
        updateDecoratedMessage();
    }

    private static void flushIfOverflow(int message) {
        if (message == Integer.MAX_VALUE) {
            flush();
        }
    }

    private static void flushIfOverflow(byte message) {
        if (message == Byte.MAX_VALUE) {
            flush();
        }
    }

    private static void flushIfStringChanged(String message) {
        if (!currentString.equals(message)) {
            flush();
        }
    }

    private static void updateDecoratedMessage() {
        switch (lastType) {
            case INT_TYPE:
                decoratedMessage = PRIMITIVE_PREFIX + (currentInt == Integer.MAX_VALUE ? "Integer.MAX_VALUE" : Integer.toString(currentInt));
                break;
            case BYTE_TYPE:
                decoratedMessage = PRIMITIVE_PREFIX + (currentByte == Byte.MAX_VALUE ? "Byte.MAX_VALUE" : Byte.toString(currentByte));
                break;
            case CHAR_TYPE:
                decoratedMessage = CHAR_PREFIX + Character.toString(currentChar);
                break;
            case BOOLEAN_TYPE:
                decoratedMessage = PRIMITIVE_PREFIX + currentBoolean;
                break;
            case STRING_TYPE:
                if (currentStringCount > 0) {
                    decoratedMessage = STRING_PREFIX + currentString + " (x" + (currentStringCount + 1) + ")";
                } else {
                    decoratedMessage = STRING_PREFIX + currentString;
                }
                break;
            case REFERENCE_TYPE:
                decoratedMessage = REFERENCE_PREFIX + currentReference;
        }
    }

    private static void setCurrentState(int message) {
        if (lastType != INT_TYPE) {
            currentInt = message;
            lastType = INT_TYPE;
        } else {
            currentInt = (message == Integer.MAX_VALUE ? Integer.MAX_VALUE : currentInt + message);
        }
    }

    private static void setCurrentState(byte message) {
        if (lastType != BYTE_TYPE) {
            currentByte = message;
            lastType = BYTE_TYPE;
        } else {
            currentByte = (message == Byte.MAX_VALUE ? Byte.MAX_VALUE : (byte)(currentByte + message));
        }
    }

    private static void setCurrentState(char message) {
        currentChar = message;
        lastType = CHAR_TYPE;
    }

    private static void setCurrentState(boolean message) {
        currentBoolean = message;
        lastType = BOOLEAN_TYPE;
    }

    private static void setCurrentState(Object message) {
        currentReference = message;
        lastType = REFERENCE_TYPE;
    }

    private static void flushIfTypeChanged(String newType) {
        if (lastType != newType && lastType != "") {
            flush();
        }
    }

    private static void setCurrentState(String message) {
        if (lastType != STRING_TYPE) {
            currentString = message;
            lastType = STRING_TYPE;
            currentStringCount = 0;
        } else if (currentString.equals(message)) {
            currentStringCount++;
        }
    }

    public static void flush(){
        print(decoratedMessage);
        resetState();
    }

    private static void resetState() {
        currentInt = 0;
        currentByte = 0;
        currentChar = 0;
        currentString = "";
        currentStringCount = 0;
        currentReference = null;
        currentBoolean = false;
        lastType = "";
    }
    /**
     * 1. Reuse
     * 2. Abstract -> Flexibility
     */
    private static void print(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
