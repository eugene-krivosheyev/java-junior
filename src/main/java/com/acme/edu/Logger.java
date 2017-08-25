package com.acme.edu;

public class Logger {
    private static boolean isPreviousInt = false;
    private static long intSum = 0;

    private static boolean isPreviousByte = false;
    private static int byteSum = 0;

    private static String previousString = null;
    private static int equalStringsCount = 0;

    public static void log(Object message) {
        if (isNull(message)) {
            return;
        }

        cachePrint();
        System.out.println("reference: " + message);
    }

    public static void log(int[] message) {
        if (isNull(message)) {
            return;
        }

        cachePrint();
        System.out.println("primitives array: " + arrayToString(message));
    }

    public static void log(int message) {
        if (!isPreviousInt) {
            cachePrint();
            isPreviousInt = true;
        }

        if (intSum + message > (long) Integer.MAX_VALUE) {
            System.out.println("primitive: " + Integer.MAX_VALUE);
            intSum = (message + intSum) % Integer.MAX_VALUE;
        } else if (intSum + message < (long) Integer.MIN_VALUE) {
            System.out.println("primitive: " + Integer.MIN_VALUE);
            intSum = (message + intSum) % Integer.MIN_VALUE;
        } else {
            intSum += message;
        }
    }

    public static void log(boolean message) {
        cachePrint();
        System.out.println("primitive: " + message);
    }

    public static void log(String message) {
        if (isNull(message)) {
            return;
        }

        if ("".equals(message)) {
            return;
        }

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
            System.out.println("primitive: " + Byte.MAX_VALUE);
            byteSum = (message + byteSum) % Byte.MAX_VALUE;
        } else if (byteSum + message < (int) Byte.MIN_VALUE) {
            System.out.println("primitive: " + Byte.MIN_VALUE);
            byteSum = (message + byteSum) % Byte.MIN_VALUE;
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

    private static boolean isNull(Object message) {
        return message == null;
    }

    private static String arrayToString(int[] a) {
        int iMax = a.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    public static void main(String[] args) {

        Logger.log(-5);
        Logger.log(Integer.MIN_VALUE);
        Logger.log(-8);
        Logger.cachePrint();
    }
}
