package com.acme.edu;


public class Logger {
    private static Buffer buffer = new Buffer();

    public static void log(int message) {
        buffer.save(message);
    }

    public static void log(byte message) {
        Printer.save(Decorator.decoratePrimitive(String.valueOf(message)));
    }

    public static void log(String message) {
        buffer.save(message);
    }

    public static void log(String... messages) {
        Printer.save(Decorator.decorateStringArray(messages));
    }

    public static void log(Integer... messages) {
        Printer.save(Decorator.decorateIntegerArray(messages));
    }

    public static void log(int[][][][] messages) {
        Printer.save(Decorator.decorateMultiMatrix(messages));
    }

    public static void log(int[][] messages) {
        Printer.save(Decorator.decorateMatrix(messages));
    }

    public static void log(int[] messages) {
        Printer.save(Decorator.decorateArray(messages));
    }

    public static void log(boolean message) {
        Printer.save(Decorator.decoratePrimitive(String.valueOf(message)));
    }

    public static void log(Object message) {
        Printer.save(Decorator.decorateReference(String.valueOf(message)));
    }

    public static void log(char message) {
        Printer.save(Decorator.decorateChar(String.valueOf(message)));
    }

    public static void close() {
        buffer.flushBuffer();
    }
}