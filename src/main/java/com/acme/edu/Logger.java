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
        return switch (message.getClass().getSimpleName()) {
            case "Integer", "Byte", "Boolean" -> PRIMITIVE_PREFIX;
            case "String" -> STRING_PREFIX;
            case "Character" -> CHAR_PREFIX;
            default -> OBJECT_PREFIX;
        };
    }

    public static void log(Object message) {
        System.out.print(getMessage(message));
    }
}

