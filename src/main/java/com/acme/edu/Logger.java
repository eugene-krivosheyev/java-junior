package com.acme.edu;

public class Logger {
    public static void log(int message) {
        save("int: " + message);
    }

    public static void log(byte message) {
        save("" + message);
    }

    private static void save(String message) {
        System.out.println("primitive: " + message);
    }
    public static void log(char message) {
        System.out.println("char: " + message);
    }
    public static void log(String message) {
        System.out.println("string: " + message);
    }
}
