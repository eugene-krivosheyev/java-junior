package com.acme.edu;

import javax.lang.model.type.PrimitiveType;

import static java.lang.System.lineSeparator;

public class Logger {
    private static int accumullatedSum = 0;
    private static String accumullatedStr = "";
    private static boolean isEmptyAccum = true;
    private static boolean isPrimitive = true;

    public static void log(int message) {
        //System.out.println("primitive: " + (accumullatedSum += message));
        accumullatedSum += message;
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
            message = accumullatedSum + lineSeparator() + message;
        }
        accumullatedSum = 0;
        isEmptyAccum = true;
        accumullatedStr += message + lineSeparator();
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
            accumullatedStr += accumullatedSum;
        }
        System.out.println(accumullatedStr);
        accumullatedStr = "";
    }
}
