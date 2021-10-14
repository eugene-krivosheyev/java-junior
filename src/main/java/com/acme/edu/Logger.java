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
}
