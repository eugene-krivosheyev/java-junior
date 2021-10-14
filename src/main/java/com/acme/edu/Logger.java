package com.acme.edu;

public class Logger {
   /* static {
        System.out.println("formatMessage(messagePrefix, message)");
    }*/
    public static void log(int message) throws IllegalStateException {
        /**
         * @throws
         * @param message
         */
        final String messagePrefix = "primitive: ";
        System.out.println(formatMessage(messagePrefix, message));
    }

    private static String formatMessage(String messagePrefix, Object message) {
        return messagePrefix + message;
    }

    public static void log(byte message) {
        final String messagePrefix = "primitive: ";
        System.out.println(formatMessage(messagePrefix, message));
    }

    public static void log(char message) {
        final String messagePrefix = "char: ";
      System.out.println(formatMessage(messagePrefix, message));
    }

    public static void log(String message) {
        final String messagePrefix = "string: ";
      System.out.println(formatMessage(messagePrefix, message));
    }

    public static void log(boolean message) {
        final String messagePrefix = "primitive: ";
      System.out.println(formatMessage(messagePrefix, message));
    }

    public static void log(Object message) {
        final String messagePrefix = "reference: ";
      System.out.println(formatMessage(messagePrefix, message));
    }
}
