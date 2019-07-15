package com.acme.edu;

<<<<<<< HEAD
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
=======
public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";

    public static void log(int message) {
        if (message == 0) return; //Guard clause

        System.out.println(PRIMITIVE_PREFIX + message);


        //========

        if (message != 0) {
            System.out.println("primitive: " + message);
        } else {
            return;
        }
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
>>>>>>> 0ac3bf5d12d32a685309e3a0991f9de5a9121844
    }
}
