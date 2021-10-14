package com.acme.edu;

public class Logger {
    public static void log(int message) {
        printToConsole("primitive: " + message);
    }

    public static void log(byte message) {
        printToConsole("primitive: " + message);
    }

    public static void log(char message) {
        printToConsole("char: " + message);
    }

    public static void log(String message) {
        printToConsole("string: " + message);
    }

    public static void log(boolean message) {
        printToConsole("boolean: " + message);
    }

    public static void log(Object message) {
        printToConsole("reference: " + message.toString());
    }

    private static void printToConsole(String message) {
        System.out.println(message);
    }
}
