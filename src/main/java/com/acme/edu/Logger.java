package com.acme.edu;

import static com.acme.edu.utils.Types.*;

public class Logger {

    public static void log(int message) {
        print(INTEGER.getPrefix() + message);
    }

    public static void log(byte message) {
        print(BYTE.getPrefix() + message);
    }

    public static void log(char message) {
        print(CHAR.getPrefix() + message);
    }

    public static void log(String message) {
        print(STRING.getPrefix() + message);
    }

    public static void log(boolean message) {
        print(BOOLEAN.getPrefix() + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
