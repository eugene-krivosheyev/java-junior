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
        setState(message);
        updateDecoratedMessage();
    }

    public static void log(byte message) {
        flushIfTypeChanged(BYTE_TYPE);
        setState(message);
        updateDecoratedMessage();
    }

    public static void log(char message) {
        flushIfTypeChanged(CHAR_TYPE);
        setState(message);
        updateDecoratedMessage();
    }

    public static void log(boolean message) {
        flushIfTypeChanged(BOOLEAN_TYPE);
        setState(message);
        updateDecoratedMessage();
    }

    public static void log(String message) {
        flushIfTypeChanged(STRING_TYPE);
        flushIfStringChanged(message);
        setState(message);
        updateDecoratedMessage();
    }

    public static void log(Object message) {
        flushIfTypeChanged(REFERENCE_TYPE);
        setState(message);
        updateDecoratedMessage();
    }

    private static void flushIfStringChanged(String message) {
        if (!currentString.equals(message)) {
            flush();
        }
    }

    private static void updateDecoratedMessage() {
        switch (lastType) {
            case INT_TYPE:
                decoratedMessage = PRIMITIVE_PREFIX + Integer.toString(currentInt);
                break;
            case BYTE_TYPE:
                decoratedMessage = PRIMITIVE_PREFIX + Byte.toString(currentByte);
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

    private static void setState(int message) {
        if (lastType != INT_TYPE) {
            currentInt = message;
            lastType = INT_TYPE;
        } else {
            if ((message < 0 && currentInt > 0) || (currentInt < 0 && message > 0)) {
                currentInt = message + currentInt;
            } else {
                int sum = currentInt + message;
                if (currentInt < 0 && sum > 0) {
                    sum = currentInt - Integer.MIN_VALUE + message;
                }
                if (currentInt > 0 && sum < 0) {
                    sum = currentInt - Integer.MAX_VALUE + message;
                }
                currentInt = sum;
            }
        }
    }

    private static void setState(byte message) {
        if (lastType != BYTE_TYPE) {
            currentByte = message;
            lastType = BYTE_TYPE;
        } else {
            if ((message < 0 && currentByte > 0) || (currentByte < 0 && message > 0)) {
                currentByte = (byte)(message + currentByte);
            } else {
                byte sum = (byte)(currentByte + message);
                if (currentByte < 0 && sum > 0) {
                    sum = (byte)(currentByte - Byte.MIN_VALUE + message);
                }
                if (currentByte > 0 && sum < 0) {
                    sum = (byte)(currentByte - Byte.MAX_VALUE + message);
                }
                currentByte = sum;
            }
        }
    }

    private static void setState(char message) {
        currentChar = message;
        lastType = CHAR_TYPE;
    }

    private static void setState(boolean message) {
        currentBoolean = message;
        lastType = BOOLEAN_TYPE;
    }

    private static void setState(Object message) {
        currentReference = message;
        lastType = REFERENCE_TYPE;
    }

    private static void flushIfTypeChanged(String newType) {
        if (lastType != newType && lastType != "") {
            print(decoratedMessage);
        }
    }

    private static void setState(String message) {
        if (lastType != STRING_TYPE || !currentString.equals(message)) {
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
