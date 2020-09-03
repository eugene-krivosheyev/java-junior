package com.acme.edu;

public class Logger {
    private static String separator = ": ";

    public static void log(int message) {
        printMessageWithType(MessageType.PRIMITIVE.getType() + separator + message);
    }

    public static void log(byte message) {
        printMessageWithType(MessageType.PRIMITIVE.getType() + separator + message);
    }

    public static void log(char message) {
        printMessageWithType(MessageType.CHAR.getType() + separator + message);
    }

    public static void log(String message) {
        printMessageWithType(MessageType.STRING.getType() + separator + message);
    }

    public static void log(boolean message) {
        printMessageWithType(MessageType.PRIMITIVE.getType() + separator + message);
    }

    public static void log(Object message) {
        printMessageWithType(MessageType.REFERENCE.getType() + separator + message);
    }

    private static void printMessageWithType(String message) {
        System.out.println(message);
    }
}

enum MessageType {
    PRIMITIVE("primitive"),
    CHAR("char"),
    STRING("string"),
    REFERENCE("reference");

    private String type;
    MessageType(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }
}
