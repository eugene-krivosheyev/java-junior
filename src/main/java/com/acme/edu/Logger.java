package com.acme.edu;

import java.sql.SQLOutput;

public class Logger {

    private static int state;
    private static String previous_type="start";
    private static String messagePrefix="";

    public static void log(int message) {
        /**
         * @throws
         * @param message
         */
        final String type = "int";
        messagePrefix = "primitive: ";
        if (type != previous_type) {
      //      flush();
            previous_type = type;
            state+=message;
        } else {
            if ((Long.valueOf(state) + Long.valueOf(message)) < Integer.MAX_VALUE) {
                state += message;
            } else {
                System.out.println(state);
                System.out.println(Integer.MAX_VALUE);
                state = message - (Integer.MAX_VALUE - state);
            }
        }
    }

    public static void log(byte message) {
        messagePrefix = "primitive: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(char message) {
        messagePrefix = "char: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(String message) {
        final String type = "str";
        messagePrefix = "string: ";
  //      if (type != previous_type) {
   //         flush();
            previous_type = type;
            state = 0;
        print(formatMessage(messagePrefix, message));
    }

    public static void log(boolean message) {
       messagePrefix = "primitive: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(Object message) {
        messagePrefix = "reference: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void flush() {
        if (previous_type != "start") {
            print(formatMessage(messagePrefix,state));
        }
        state = 0;
    }

    private static String formatMessage(String messagePrefix, Object message) {
        return messagePrefix + message;
    }

    private static void print(String message) {
        System.out.println(message);
    }


}
