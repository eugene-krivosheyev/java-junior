package com.acme.edu;

//TODO To think
public class Logger {
    public static void log(int message) {
        print("primitive", Integer.toString(message));
    }

    public static void log(byte message) {
        print("primitive", Byte.toString(message));
    }

    public static void log(char message) {
        print("char", Character.toString(message));
    }

    public static void log(boolean message) {
        print("primitive", Boolean.toString(message));
    }

    public static void log(String message) {
       print("string", message);
    }

    public static void log(Object message) {
        print("reference", message.toString());
    }

    public static void print(String type, String message) {
        System.out.println(type +": " + message);
    }

}
