package com.acme.edu;
import com.acme.edu.Printer;

import java.util.Objects;

public class Logger {

    private final static String PRIMITIVE_CONST_MESSAGE = "primitive: ";
    private final static String CHAR_CONST_MESSAGE = "char: ";
    private final static String STRING_CONST_MESSAGE = "string: ";
    private final static String REFERENCE_CONST_MESSAGE = "reference: ";

    private static void logPrimitive(String message) {
        Printer.print(PRIMITIVE_CONST_MESSAGE + message);
    }

    public static void log(int message) {
        logPrimitive(String.valueOf(message));
    }

    public static void log(byte message) {
        logPrimitive(String.valueOf(message));
    }

    public static void log(boolean message) {
        logPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        Printer.print(CHAR_CONST_MESSAGE + message);
    }

    public static void log(String message) {
        Printer.print(STRING_CONST_MESSAGE + message);
    }

    public static void log(Object message) {
        Printer.print(REFERENCE_CONST_MESSAGE + message);
    }


}
