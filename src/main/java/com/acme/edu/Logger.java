package com.acme.edu;

import java.sql.SQLOutput;
import java.util.Objects;

public class Logger {

    private static int state;
    private static String state_string = null;
    private static int counter = 1;
    private static String previous_type = "start";
    private static String messagePrefix = "";

    public static void log(int message) {
        /**
         * @throws
         * @param message
         */
        final String type = "int";
        messagePrefix = "primitive: ";
        if (type != previous_type) {
            flush();
            previous_type = type;
            state += message;
        } else {
            if ((Long.valueOf(state) + Long.valueOf(message)) < Integer.MAX_VALUE) {
                state += message;
            } else {
                // System.out.println(state);
                System.out.println(Integer.MAX_VALUE);
                state = message - (Integer.MAX_VALUE - state);
            }
        }
    }

    public static void log(byte message) {
        final String type = "byte";
        messagePrefix = "primitive: ";
        if (type != previous_type) {
            flush();
            previous_type = type;
            state += message;
        } else {
            if ((Integer.valueOf(state) + Integer.valueOf(message)) < Byte.MAX_VALUE) {
                state += message;
            } else {
                // System.out.println(state);
                System.out.println(Byte.MAX_VALUE);
                state = message - (Byte.MAX_VALUE - state);
            }
        }
    }

    public static void log(char message) {
        messagePrefix = "char: ";
        print(formatMessage(messagePrefix, message));
    }

    public static void log(String message) {
        final String type = "str";
        if (type != previous_type) {
            flush();
        } else {
            if (Objects.equals(message, state_string)) {
                counter++;
            } else {
                flush();
                counter = 1;
            }
        }
        messagePrefix = "string: ";
        previous_type = type;
        state = 0;
        state_string = message;
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
        if (previous_type != "start" && (previous_type == "int" || previous_type == "byte")) {
            print(formatMessage(messagePrefix, state));
        } else if (previous_type != "start" && previous_type == "str") {
            if (counter == 1) print(formatMessage(messagePrefix, state_string));
            else {
                System.out.println(state_string + " (x" + counter + ")");
            }
        }
        state = 0;
        counter = 1;
    }

    private static String formatMessage(String messagePrefix, Object message) {
        return messagePrefix + message;
    }

    private static void print(String message) {
        System.out.println(message);
    }


}
