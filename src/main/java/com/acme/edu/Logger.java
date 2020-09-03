package com.acme.edu;

public class Logger {
    private final static String
            PREFIX_CHAR = "char: ",
            PREFIX_STRING = "string: ",
            PREFIX_REFERENCE = "reference: ",
            PREFIX_PRIMITIVE = "primitive: ";

    public static void log(int message) {
        directToOutput(PREFIX_PRIMITIVE + message);
    }

    public static void log(char message) {
        directToOutput(PREFIX_CHAR + message);
    }

    public static void log(boolean message) {
        directToOutput(PREFIX_PRIMITIVE + message);
    }

    public static void log(Object message) {
        directToOutput(PREFIX_REFERENCE + message);
    }

    public static void log(String message) {
        directToOutput(PREFIX_STRING + message);
    }

    public static void log(byte message) {
        directToOutput(PREFIX_PRIMITIVE + message);
    }

    static void directToOutput (String outputString){
        System.out.println(outputString);
    }
}