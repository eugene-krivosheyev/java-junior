package com.acme.edu;

public class Logger {
    public static void log(int message) {
        printMessageWithType("primitive: " + message);
    }

    public static void log(byte message) {
        printMessageWithType("primitive: " + message);
    }

    public static void log(char message) {
        printMessageWithType("char: " + message);
    }

    public static void log(String message) {
        printMessageWithType("string: " + message);
    }

    public static void log(boolean message){
        printMessageWithType("primitive: " + message);
    }

    public static void log(Object message){
        printMessageWithType("reference: " + message);
    }

    private static void printMessageWithType(String message){
        System.out.println(message);
    }
}
