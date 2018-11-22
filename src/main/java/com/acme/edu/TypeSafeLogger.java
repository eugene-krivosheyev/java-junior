package com.acme.edu;


public class TypeSafeLogger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String STRING_PREFIX = "string: ";


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
        if (lastType != "int" && lastType != "") {
            flush();
            currentInt = message;
            decoratedMessage = PRIMITIVE_PREFIX + message;
        } else if (message == Integer.MAX_VALUE) {
            flush();
            decoratedMessage = "Integer.MAX_VALUE";
        }
        else {
            currentInt = currentInt + message;
            decoratedMessage = PRIMITIVE_PREFIX + currentInt;
        }
        lastType = "int";
    }

    public static void log(byte message) {
        if (lastType != "byte" && lastType != "") {
            flush();
            currentByte = message;
            decoratedMessage = PRIMITIVE_PREFIX + message;
        } else if (message == Byte.MAX_VALUE) {
            flush();
            decoratedMessage = "Byte.MAX_VALUE";
        }
        else {
            currentByte = (byte) (currentByte + message);
            decoratedMessage = PRIMITIVE_PREFIX + currentByte;
        }
        lastType = "byte";
    }

    private static void updateDecoratedMessage(String prefix, String message) {
        decoratedMessage = prefix + message;
    }

    public static void log(char message) {
        if (lastType != "char" && lastType != "") {
            flush();
            currentChar = message;
        } else {
            currentChar = message;
        }
        updateDecoratedMessage(CHAR_PREFIX, Character.toString(currentChar));
        lastType = "char";
    }

    public static void log(boolean message) {
        if (lastType != "boolean" && lastType != "") {
            flush();
            currentBoolean = message;
        } else {
            currentBoolean = message;
        }
        updateDecoratedMessage(PRIMITIVE_PREFIX, Boolean.toString(currentBoolean));
        lastType = "boolean";
    }

    public static void log(String message) {
        if (lastType != "string" && lastType != "") {
            flush();
            currentString = message;
        } else {
            if (currentString.equals(message)) {
                currentStringCount++;
            } else {
                flush();
                currentString = message;
            }
        }
        if (currentStringCount > 0) {
            decoratedMessage = STRING_PREFIX + currentString + " (x" + (currentStringCount + 1) + ")";
        } else {
            decoratedMessage = STRING_PREFIX + currentString;
        }
        lastType = "string";
    }

    public static void log(Object message) {
        if (lastType != "reference" && lastType != "") {
            flush();
            currentReference = message;
        } else {
            currentReference = message;
        }
        updateDecoratedMessage(REFERENCE_PREFIX, currentReference.toString());
        lastType = "reference";
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

    }
    /**
     * 1. Reuse
     * 2. Abstract -> Flexibility
     */
    private static void print(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
