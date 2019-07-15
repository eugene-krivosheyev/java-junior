package com.acme.edu;

import javax.lang.model.type.PrimitiveType;

public class Logger {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        if (message == null) {
            System.out.println("reference: null");
            return;
        }
        System.out.println("reference: " + message);
    }
}
