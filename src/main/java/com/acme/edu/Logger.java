package com.acme.edu;


public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String STRING = "string: ";
    private static final String CHAR = "char: ";
    private static final String REFERENCE = "reference: ";

    public static void log(int message) {
        print(PRIMITIVE + message);
    }

    public static void log(byte message) {
        print(PRIMITIVE + message);
    }

    public static void log(String message) {
        print(STRING + message);
    }

    public static void log(boolean message) {
        print(PRIMITIVE + message);
    }

    public static void log(char message) {
        print(CHAR + message);
    }

    public static void log(Object message) {
        print(REFERENCE + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }



    /*
    private static String getTypeMessage(Object message) {
        if (message instanceof String) {
            return "string";
        } else if (message instanceof Character) {
            return "char";
        } else if (message instanceof Boolean || message instanceof Byte || message instanceof Integer) {
            return "primitive";
        } else {
            return "reference";
        }
    }*/


}