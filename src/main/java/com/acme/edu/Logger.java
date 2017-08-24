package com.acme.edu;

public class Logger {
    private static boolean isPreviousInt = false;
    private static long intSum = 0;

    private static boolean isPreviousByte = false;
    private static int byteSum = 0;

    private static String previousString = null;
    private static int equalStringsCount = 0;

    public static void log(Object message) {
        cachePrint();
        System.out.println("reference: " + message);
    }

    public static void log(int message) {
        if (!isPreviousInt) {
            cachePrint();
            isPreviousInt = true;
        }

        if (intSum + message > (long) Integer.MAX_VALUE) {
            System.out.println("primitive: " + intSum);
            intSum = message;
        } else {
            intSum += message;
        }
    }

    public static void log(boolean message) {
        cachePrint();
        System.out.println("primitive: " + message);
    }

    public static void log(String message) {
        if (previousString == null || !previousString.equals(message)) {
            cachePrint();
            previousString = message;
            equalStringsCount = 1;
        } else {
            equalStringsCount++;
        }
    }

    public static void log(char message) {
        cachePrint();
        System.out.println("char: " + message);
    }

    public static void log(byte message) {
        if (!isPreviousByte) {
            cachePrint();
        }

        isPreviousByte = true;
        if (byteSum + message > (int) Byte.MAX_VALUE) {
            System.out.println("primitive: " + byteSum);
            byteSum = message;
        } else {
            byteSum += message;
        }
    }

    public static void cachePrint() {
        if (isPreviousInt) {
            System.out.println("primitive: " + intSum);
            intSum = 0;
            isPreviousInt = false;
        }

        if (isPreviousByte) {
            System.out.println("primitive: " + byteSum);
            byteSum = 0;
            isPreviousByte = false;
        }

        if (previousString != null) {
            String appendix = (equalStringsCount > 1) ? " (x" + equalStringsCount + ")" : "";
            System.out.println("string: " + previousString + appendix);
            equalStringsCount = 0;
            previousString = null;
        }
    }
}
