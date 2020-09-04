package com.acme.edu;

import java.lang.reflect.Type;

public class Logger {

    public static String type = "";
    public static int counter = 1;
    public static Object value;

    public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: ";

    public static void log(int message) {
        if (counter == 0) {
            writeMessage(PREFIX_PRIMITIVE + message);
            counter = 1;
        }
        else{
            if (type.equals("")) {
                type = "int";
                value = message;
            } else {
                if ("int".equals(type)) {
                    value = (int)value + message;
                } else {
                    counter = 0;
                    log(value.getClass().cast(value));
                    type = "int";
                    value = message;
                }
            }
        }
    }

    public static void log(byte message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(char message) {
        writeMessage(PREFIX_CHAR + message);
    }

    public static void log(boolean message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(String message) {
        if (counter == 0) {
            writeMessage(PREFIX_STRING + message);
            counter = 1;
        }
        else{
            if (type.equals("")) {
                type = "String";
                value = message;
            } else {
                if ("String".equals(type)) {
                    if (message.equals(value)) {
                        counter = 2;
                        message = message + " (x" + counter + ")";
                    } else {
                        counter = 1;
                        message += value;
                    }
                } else {
                    counter = 0;
                    log(value);
                    type = "String";
                    value = message;
                }
            }
        }
    }

    public static void log(Object message) {
        writeMessage(PREFIX_REFERENCE + message);
    }

    private static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void cleanBuffer() {
        counter = 0;
        log(value);
    }
}
