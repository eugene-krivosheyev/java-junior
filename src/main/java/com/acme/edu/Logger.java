package com.acme.edu;

public class Logger {
    final static String
            PREFIX_CHAR = "char: ",
            PREFIX_STRING = "string: ",
            PREFIX_REFERENCE = "reference: ",
            PREFIX_PRIMITIVE = "primitive: ";

   public static void log(int message) {
        System.out.println(": " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }*/
}
