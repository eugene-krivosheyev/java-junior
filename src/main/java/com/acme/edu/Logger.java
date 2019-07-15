package com.acme.edu;

public class Logger {
    private static void mainLog(String type, String message){
        System.out.println(type + ": " + message);
    }

    public static void log(int message) {
        mainLog("primitive", String.valueOf(message));
    }

    public static void log(char message) {
        mainLog("char", String.valueOf(message));
    }

    public static void log(String message) {
        mainLog("string", String.valueOf(message));
    }

    public static void log(boolean message) {
        mainLog("primitive", String.valueOf(message));
    }

    public static void log(Object message) {
        if(message != null) {
            mainLog("reference", message.toString());
        }
    }

    public static void log(byte message) {
        mainLog("primitive",String.valueOf(message));
    }
}
