package com.acme.edu;

public class Logger {


    private static void print(String type,String message) {
        System.out.println(prefix(type) + message);
    }

    private static String prefix(String type) {
        if (String.class.getTypeName() == type){
            return "string: ";
        } else if (char.class.getTypeName() == type){
            return "char: ";
        } else if (Object.class.getTypeName() == type){
            return "reference: ";
        } else {
            return "primitive: ";
        }
    }

    public static void log(int message) {
        print(int.class.getTypeName(),String.valueOf(message));
    }

    public static void log(char message) {
        print(char.class.getTypeName(),String.valueOf(message));
    }

    public static void log(byte message) {
        print(byte.class.getTypeName(),String.valueOf(message));
    }
    public static void log(String message) {
        print(String.class.getTypeName(),String.valueOf(message));
    }
    public static void log(Boolean message) {
        print(Boolean.class.getTypeName(),String.valueOf(message));
    }
    public static void log(Object message) {
        print(Object.class.getTypeName(),String.valueOf(message));
    }
}
