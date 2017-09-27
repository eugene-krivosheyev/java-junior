package com.acme.edu;

public class Logger {


    //region const
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIF = "char: ";
    //endregion

    public static void log(byte message) {
        print(PRIMITIVE_PREFIX + "\n" + message);
    }

    public static void log(char message) {
        print(CHAR_PREFIF +"\n" + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(int message) {
        System.out.print(PRIMITIVE_PREFIX + message + "\n");
    }

    private static void print(String message) {
        System.out.println("string: ");
        System.out.println(message);
    }

}

