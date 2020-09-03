package com.acme.edu;

public class Logger {

    static String primitivePrefix = "primitive";
    static String charPrefix = "char";
    static String stringPrefix = "string";
    static String objPrefix = "reference";

    public static void log(int message) {
        printLogMessage(primitivePrefix, message);
    }

    public static void log(byte message) {
        printLogMessage(primitivePrefix, message);
    }

    public static void log(char message) {
        printLogMessage(charPrefix, message);
    }

    public static void log(String message) {
        printLogMessage(stringPrefix, message);
    }

    public static void log(boolean message) {
        printLogMessage(primitivePrefix, message);
    }

    public static void log(Object message) {
        printLogMessage(objPrefix, message);
    }

    public static void printLogMessage(String prefix, Object message) {
        System.out.println(prefix + ": " + message.toString());
    }

}
