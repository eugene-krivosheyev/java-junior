package com.acme.edu;

import static java.lang.System.lineSeparator;

public class Logger {
    private static int accumulatedSum = 0;
    private static String accumulatedStr = "";
    private static boolean isEmptyAccum = true;
    private static boolean isPrimitive = true;

    public static void log(int message) {
        //System.out.println("primitive: " + (accumulatedSum += message));
        accumulatedSum += message;
        isEmptyAccum = false;
        //flush();
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        if (!isEmptyAccum) {
            message = accumulatedSum + lineSeparator() + message;
        }
        accumulatedSum = 0;
        isEmptyAccum = true;
        accumulatedStr += message + lineSeparator();
        //System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        if (message == null) {
            System.out.println("reference: null");
            return;
        }
        System.out.println("reference: " + message);
    }

    public static void flush() {
        if (!isEmptyAccum) {
            accumulatedStr += accumulatedSum;
        }
        System.out.println(accumulatedStr);
        accumulatedStr = "";
    }
}
