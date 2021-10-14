package com.acme.edu;

public class Logger {
   /* static {
        print("formatMessage(messagePrefix, message)");
    }*/
//    public static void log(int message) throws IllegalStateException {
//        /**
//         * @throws
//         * @param message
//         */
//        final String messagePrefix = "primitive: ";
//        print(formatMessage(messagePrefix, message));
//    }
//
    private static String formatMessage(String messagePrefix, Object message) {
        return messagePrefix + message;
    }

    private static void print(String message){
        System.out.println(message);
    }

//    public static void log(byte message) {
//        final String messagePrefix = "primitive: ";
//        print(formatMessage(messagePrefix, message));
//    }
//
//    public static void log(char message) {
//        final String messagePrefix = "char: ";
//      print(formatMessage(messagePrefix, message));
//    }
//
//    public static void log(String message) {
//        final String messagePrefix = "string: ";
//      print(formatMessage(messagePrefix, message));
//    }
//
//    public static void log(boolean message) {
//        final String messagePrefix = "primitive: ";
//      print(formatMessage(messagePrefix, message));
//    }

    public static void log(Object message) {
        String messagePrefix;
        if (message.getClass() == Integer.class) {
            messagePrefix = "primitive: ";
        }
        else if (message.getClass() == String.class) {
            messagePrefix = "string: ";
        }
        else if (message.getClass() == Boolean.class) {
            messagePrefix = "primitive: ";
        }
        else if (message.getClass() == Character.class) {
            messagePrefix = "char: ";
        }
        else if (message.getClass() == Byte.class) {
            messagePrefix = "primitive: ";
        }

        else {
            messagePrefix = "reference: ";
        }
      print(formatMessage(messagePrefix, message));
    }
}
