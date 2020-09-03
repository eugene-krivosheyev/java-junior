package com.acme.edu;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

public class Logger {

    private static String primitiveType = "primitive: ";

    private static String charType = "char: ";

    private static String stringType = "string: ";

    private static String referenceType = "reference: ";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printBuffer(types last) {
        switch (last) {
            case INTEGER:
                printMessage(primitiveType + savedInt);
                break;
            case BYTE:
                printMessage(primitiveType + savedByte);
                break;
            case STRING:
                printMessage(stringType + savedString);
                break;
        }
    }

    private static void resetBuffer() {
        savedString = "";
        savedInt = 0;
        savedByte = 0;
    }

    static int savedInt = 0;
    static String savedString = "";
    static byte savedByte = 0;
    static types last = null;

    enum types {
        INTEGER ,
        BYTE ,
        STRING,
        NONE
    }

    public static void main(String[] args) {
        //System.out.println("djsj");
        log(10);
        log(3);
        log("12");
    }

    public static void log(int message) {
        if (last != types.INTEGER && last != null) {
            printBuffer(last);
            resetBuffer();
        }
        savedInt += message;
        last = types.INTEGER;
    }

    public static void log(byte message) {
        if (last != types.BYTE) {
            printBuffer(last);
            resetBuffer();
        }
        savedByte += message;
        last = types.BYTE;
    }

    public static void log(char message) {
        printMessage(charType + message);
    }

    public static void log(String message) {
        if (last != types.STRING) {
            printBuffer(last);
            resetBuffer();
        }
        savedString += message;
        last = types.STRING;
    }

    public static void log(boolean message) {
        printMessage(primitiveType + message);
    }

    public static void log(Object message) {
        printMessage(referenceType + message);
    }
}
