package com.acme.edu;

public class Logger {


    //region const
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String REF_PREFIX = "reference: ";
    public static final String STRING_PREF = "string: ";

    //endregion

    public static void log(byte message) {
        print(PRIMITIVE_PREFIX + "\n" + message);
    }

    public static void log(int message) {
        print(PRIMITIVE_PREFIX + message + "\n");
    }

    public static void log(boolean message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX +"\n" + message);
    }

    public static void log(String message) {
        print(STRING_PREF + message);
    }

    public static void log(Object message) {
        print(REF_PREFIX + "@"+ message);
    }


    private static void print(String message) {
        System.out.print(message);
    }



}

