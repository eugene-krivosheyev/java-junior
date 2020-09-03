package com.acme.edu;

public class Logger {
    public static void print(String nameType, Object message) { System.out.println(nameType + message); }

    public static void log(int message) { print("primitive: ", message); }

    public static void log(byte message) { print("primitive: ", message); }

    public static void log(char message) {
        print("char: ", message);
    }

    public static void log(String message) {
        print("string: ", message);
    }

    public static void log(boolean message) {
        print("primitive: ", message);
    }

    public static void log(Object message) {
        print("reference: ", message);
    }

}
