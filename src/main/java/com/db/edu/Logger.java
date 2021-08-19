package com.db.edu;

public class Logger {
    public static void log(Object message) {
        String type = getTypeByClass(message);
        log(type, message);
    }

    private static String getTypeByClass(Object message) {
        String className = message.getClass().getSimpleName();
        switch (className) {
            case "Integer":
            case "Byte":
            case "Boolean":
                return  "primitive: ";
            case "String":
                return  "string: ";
            case "Character":
                return  "char: " ;
            default:
                return "reference: ";
        }
    }

    private static void log(String type, Object message) {
        System.out.print(type + message + System.lineSeparator());
    }
}