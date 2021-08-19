package com.acme.edu;

public class Logger {
    private static String getMessage(Object message) {
        return getMessagePrefix(message) + message + "\n";
    }

    private static String getMessagePrefix(Object message) {
        return switch (message.getClass().getSimpleName()) {
            case "Integer", "Byte", "Boolean" -> "primitive: ";
            case "String" -> "string: ";
            case "Character" -> "char: ";
            default -> "reference: ";
        };
    }

    public static void log(Object message) {
        System.out.print(getMessage(message));
    }
}

