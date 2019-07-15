package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";

    public static void log(int message) {
        if (message == 0) return; //Guard clause

        System.out.println(PRIMITIVE_PREFIX + message);


        //========

        if (message != 0) {
            System.out.println("primitive: " + message);
        } else {
            return;
        }
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }
}
