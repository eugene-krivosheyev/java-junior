package com.acme.edu;

public class Logger {
    enum MessageTypePrefix {
        PRIMITIVE("primitive: "),
        CHAR("char: "),
        STRING("string: "),
        REFERENCE("reference: ");

        private String typePrefix;

        MessageTypePrefix(String typePrefix) {
            this.typePrefix = typePrefix;
        }

        String getTypePrefix() {
            return typePrefix;
        }
    }

    public static void log(int message) {
        printMessageWithType(MessageTypePrefix.PRIMITIVE.getTypePrefix() + message);
    }

    public static void log(byte message) {
        printMessageWithType(MessageTypePrefix.PRIMITIVE.getTypePrefix() + message);
    }

    public static void log(char message) {
        printMessageWithType(MessageTypePrefix.CHAR.getTypePrefix() + message);
    }

    public static void log(String message) {
        printMessageWithType(MessageTypePrefix.STRING.getTypePrefix() + message);
    }

    public static void log(boolean message) {
        printMessageWithType(MessageTypePrefix.PRIMITIVE.getTypePrefix() + message);
    }

    public static void log(Object message) {
        printMessageWithType(MessageTypePrefix.REFERENCE.getTypePrefix() + message);
    }

    private static void printMessageWithType(String message) {
        System.out.println(message);
    }
}
