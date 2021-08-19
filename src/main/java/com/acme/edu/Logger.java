package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String OBJECT_PREFIX = "reference: ";

    private static String getMessage(Object message) {
        return getMessagePrefix(message) + message + "\n";
    }

    private static String getMessagePrefix(Object message) {
        switch (message.getClass().getSimpleName()) {
            case "Integer":
            case "Byte":
            case "Boolean":
                return PRIMITIVE_PREFIX;
            case "String":
                return STRING_PREFIX;
            case "Character":
                return CHAR_PREFIX;
            default:
                return OBJECT_PREFIX;
        }
    }

    public static void log(Object message) {
        System.out.print(getMessage(message));
    }
}

