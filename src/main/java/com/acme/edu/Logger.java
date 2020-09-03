package com.acme.edu;

public class Logger {
    private static void printMessage(String message) {
        System.out.println(message);
    }
    public static void log(int message) {
        printMessage("primitive: " + message);
    }

    public static void log(byte message) {
        printMessage("primitive: " + message);
    }

    public static void log(char message) {
        printMessage("char: " + message);
    }

    public static void log(String message) {
        printMessage("string: " + message);
    }

    public static void log(boolean message) {
        printMessage("primitive: " + message);
    }
}
