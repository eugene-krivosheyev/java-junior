package com.acme.edu;

import java.util.Objects;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    private static byte storedByte = 0;
    private static int storedInt = 0;
    private static String storedString = "";
    private static int storedCounter = 0;
    private static String storedType = null;
    private static String fullMessage = "";

    private static String formMessage() {
        String message = "";
        if (storedType == null) {
            return "";
        }
        switch (storedType) {
            case "byte":
                message += PRIMITIVE + storedByte + System.lineSeparator();
                break;
            case "int":
                message += PRIMITIVE + storedInt + System.lineSeparator();
                break;
            case "string":
                message += STRING + storedString + " (x" + storedCounter + ")" + System.lineSeparator();
                break;
        }
        return message;
    }

    public static void flush() {
        System.out.println(fullMessage);
        fullMessage = "";
    }

    private static void save(String decoratedMessage) {
        fullMessage += decoratedMessage + System.lineSeparator();
    }

    public static void log(int message) {
        if (!Objects.equals(storedType , "int")) {
            String formedMessage = formMessage();
            if (!Objects.equals(formedMessage, "")) {
                save(formedMessage);
            }
            storedType = "int";
            storedByte = 0;
            storedCounter = 1;
            storedString = "";
        }
        storedInt += message;
    }

    public static void log(byte message) {
        if (!Objects.equals(storedType , "byte")) {
            String formedMessage = formMessage();
            if (!Objects.equals(formedMessage, "")) {
                save(formedMessage);
            }
            storedType = "byte";
            storedInt = 0;
            storedCounter = 1;
            storedString = "";
        }
        storedByte += message;
    }

    public static void log(char message) {
        String decoratedMessage = CHAR + message;
        save(decoratedMessage);
    }

    public static void log(String message) {
        if (!Objects.equals(storedType , "string") || !Objects.equals(storedString, message)) {
            String formedMessage = formMessage();
            if (!Objects.equals(formedMessage, "")) {
                save(formedMessage);
            }
            storedType = "string";
            storedByte = 0;
            storedInt = 0;
            storedCounter = 1;
        }
        storedString = message;
        storedCounter = 1;
    }

    public static void log(boolean message) {
        String decoratedMessage = PRIMITIVE + message;
        save(decoratedMessage);
    }

    public static void log(Object message) {
        String decoratedMessage = REFERENCE + message;
        save(decoratedMessage);
    }
}
