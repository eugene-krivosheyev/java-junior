package com.acme.edu;

import static java.lang.String.valueOf;

public class Logger {
    private static void typeLog(String type, String message) {
        System.out.println(type + ": " + message);
    }

    private static void primitiveTypeLog(String message) {
        System.out.println("primitive: " + message);
    }

    public static void log(int message) {
        primitiveTypeLog(valueOf(message));
    }

    public static void log(byte message) {
        primitiveTypeLog(valueOf(message));
    }

    public static void log(boolean message) {
        primitiveTypeLog(valueOf(message));
    }

    public static void log(char message) {
        typeLog("char", valueOf(message));
    }

    public static void log(String message) {
        typeLog("string", valueOf(message));
    }


    public static void log(Object message) {
        if (message != null) {
            typeLog("reference", message.toString());
        } else {
            typeLog("reference", "null");
        }
    }


}
