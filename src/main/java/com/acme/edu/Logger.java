package com.acme.edu;

public class Logger {
    private static String prefix = null;
    private static void getPrintln(Object message) {
        System.out.println(prefix + message);
    }

    public static void log(int message) {
        prefix="primitive: ";
        getPrintln(message);
    }

    public static void log(byte message) {
        prefix="primitive: ";
        getPrintln(message);
    }

    public static void log(char message) {
        prefix="char: ";
        getPrintln(message);
    }

    public static void log(String message) {
        prefix="string: ";
        getPrintln(message);
    }

    public static void log(boolean message) {
        prefix="primitive: ";
        getPrintln(message);
    }

    public static void log(Object message) {
        prefix="reference: ";
        getPrintln(message);
    }


}
