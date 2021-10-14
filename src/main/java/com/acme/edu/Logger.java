package com.acme.edu;

public class Logger {

    private static String prefix = null;

    public static void log(int message) {
        prefix = "primitive: ";
        sendToSystemOut(message);
    }

    public static void log(byte message) {
        prefix = "primitive: ";
        sendToSystemOut(message);
    }

    public static void log(char message) {
        prefix = "char: ";
        sendToSystemOut(message);
    }

    public static void log(String message) {
        prefix = "string: ";
        sendToSystemOut(message);
    }

    public static void log(boolean message) {
        prefix = "primitive: ";
        sendToSystemOut(message);
    }

    public static void log(Object message) {
        prefix = "reference: ";
        sendToSystemOut(message);
    }

    private static void sendToSystemOut(Object message) {
        System.out.println(prefix + message);
    }
}
