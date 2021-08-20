package com.acme.edu;

import java.util.Objects;

public class Logger {
    public static String PRIMITIVE_TYPE = "primitive: ";
    public static String CHAR_TYPE = "char: ";
    public static String STRING_TYPE = "string: ";
    public static String REFERENCE_TYPE = "reference: ";

    private static int intSequenceSum = 0;
    private static boolean intAccumulate = false;

    private static String lastStr = null;
    private static int strCounter = 1;


    public static void log(int message) {
        logMultipleString(message + "");
        logMultipleInt(message);

        System.out.println(PRIMITIVE_TYPE + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_TYPE + message);
    }

    public static void log(char message) {
        System.out.println(CHAR_TYPE + message);
    }

    public static void log(String message) {
        logMultipleString(message + "");
        logMultipleInt(message);
        System.out.println(STRING_TYPE + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_TYPE + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_TYPE + message);
    }

    private static void logMultipleString(String message) {
        if (Objects.equals(lastStr, message)) {
            strCounter++;
        }
        else {
            if (strCounter >= 2) {
                System.out.println(lastStr + " (x" + strCounter + ")");
            }
            else {
                // nothing
            }
            lastStr = message;
            strCounter = 1;
        }
    }

    public static void logMultipleInt(Object message) {
        if (message instanceof Number) {
            intAccumulate = true;
            intSequenceSum += (int)message;
        } else {
            if (intAccumulate) {
                System.out.println(intSequenceSum);
                intAccumulate = false;
            }
        }
    }

    public static void flush() {
        if (strCounter > 1) {
            System.out.println(lastStr + " (x" + strCounter + ")");
        }
        if (intAccumulate) {
            System.out.println(intSequenceSum);
        }
    }
}
