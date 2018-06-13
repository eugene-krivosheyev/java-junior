package com.acme.edu;

public class Logger {
    private static int integerChainSum;

    public static void flushIntegerBuffer() {
        output("primitive: " + integerChainSum, false);
        integerChainSum = 0;
    }

    public static void log(int message) {
        integerChainSum += message;
    }

    public static void log(byte message) {
        output("primitive: " + message, true);
    }

    public static void log(char message) {
        output("char: " + message, true);
    }

    public static void log(String message) {
        output("string: " + message, true);
    }

    public static void log(boolean message) {
        output("primitive: " + message, true);
    }

    public static void log(Object message) {
        output("reference: " + message, true);
    }


    private static void output(String decoratedMessage, boolean needToFlushIntBuffer) {
        if (needToFlushIntBuffer) {
            flushIntegerBuffer();
        }
        System.out.println(decoratedMessage);
    }
}
