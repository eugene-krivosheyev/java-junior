package com.acme.edu;

public class Logger {
    public static void log(int message) {
        printOutput("primitive: " + message);
    }

    public static void log(boolean message) {
        printOutput("primitive: " + message);
    }

    public static void log(char message) {
        printOutput("char: " + message);
    }

    public static void log(String message) {
        printOutput("string: " + message);
    }

    public static void log(Object message) {
        printOutput("reference: " + message);
    }

    public static void printOutput(String message) {
        System.out.println(message);
    }
}
