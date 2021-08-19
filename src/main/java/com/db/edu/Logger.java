package com.db.edu;

import java.io.IOException;
import java.io.OutputStream;

public class Logger {

    private static OutputStream DEFAULT_OUT = System.out;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    private Logger() {
    }


    public static OutputStream getDefaultOut() {
        return DEFAULT_OUT;
    }

    public static void setDefaultOut(OutputStream defaultOut) {
        DEFAULT_OUT = defaultOut;
    }

    public static void log(int message) {
        writeMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(byte message) {
        writeMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(char message) {
        writeMessage(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message)  {
        writeMessage(decorate(STRING_PREFIX, message));
    }

    public static void log(boolean message) {
        writeMessage(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        writeMessage(decorate(REFERENCE_PREFIX, message));
    }

    private static String decorate(String prefix, Object message) {
        return prefix + message + System.lineSeparator();
    }

    private static void writeMessage(String message) {
        try {
            DEFAULT_OUT.write(message.getBytes());
        } catch (IOException e) {
            System.out.println("An error occurred during logging: " + e);
        }
    }

}
