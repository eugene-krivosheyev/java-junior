package com.acme.edu;

public class Logger {
    private final static String
            PREFIX_CHAR = "char: ",
            PREFIX_STRING = "string: ",
            PREFIX_REFERENCE = "reference: ",
            PREFIX_PRIMITIVE = "primitive: ";

    public static void log(int message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(char message) {
        writeMessage(PREFIX_CHAR + message);
    }

    public static void log(boolean message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(Object message) {
        writeMessage(PREFIX_REFERENCE + message);
    }

    public static void log(String message) {
        writeMessage(PREFIX_STRING + message);
    }

    public static void log(byte message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    static void writeMessage(String outputString){
        System.out.println(outputString);
    }
}