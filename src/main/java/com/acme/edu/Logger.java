package com.acme.edu;

public class Logger {

    private static int state;
    private static String previous_type;

    public static void log(int message) {
        /**
         * @throws
         * @param message
         */
        final String type = "int";
        final String messagePrefix = "primitive: ";
        if (type != previous_type) {
            previous_type = type;
            flush();
        } else {
            if (state < Integer.MAX_VALUE) {
                state += message;
            } else {
                System.out.println(Integer.MAX_VALUE);
                state = message - (Integer.MAX_VALUE - state);
            }
        }
    }

    public static void log(byte message) {
        final String messagePrefix = "primitive: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(char message) {
        final String messagePrefix = "char: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(String message) {
        final String type = "str";
        final String messagePrefix = "string: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(boolean message) {
        final String messagePrefix = "primitive: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(Object message) {
        final String messagePrefix = "reference: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void flush(){
        System.out.println(state);
        state = 0;
    }

    private static String formatMessage(String messagePrefix, Object message) {
        return messagePrefix + message;
    }

    private static void print(String message) {
        System.out.println(message);
    }


}
