package com.acme.edu;

public class Logger {
    public static void log(int message) {
        System.out.print("primitive: " + message + "\n");
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.print("char: " + message + "\n");
    }

    public static void log(String message) {
        System.out.print("string: : " + message + "\n");
    }

    public static void log(boolean message) {
        System.out.print("primitive: : " + message + "\n");
    }

    public static void log(Object object) {
        System.out.print("reference: : " + object.toString() + "\n");
    }
}
