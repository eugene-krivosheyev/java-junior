package com.acme.edu;

import java.io.PrintStream;

public class Logger {
    private static PrintStream out = System.out;

    enum Type {
        UNDEFINED,
        STRING,
        INTEGER,
        BYTE
    }
    static String value;
    static Type type = Type.UNDEFINED;
    static int counter = 0;


    // TODO: flush
    public static void flash() {
        switch (type) {
            case STRING:
                handleString("");
                counter = 0;
                break;
            case INTEGER:
            case BYTE:
                handlePrimitive("");
                break;
        }
        type = Type.UNDEFINED;
    }

    public static void setPrintStream(PrintStream newPrintStream) {
        out = newPrintStream;
    }

    public static void log(int message) {
        switch (type) {
            case STRING:
                handleString("" + message);
                break;
            case INTEGER:
                int number = Integer.parseInt(value);
                if (number + (long)message > Integer.MAX_VALUE) {
                    printToOutput("primitive: " + number);
                    printToOutput("primitive: " + message);
                }
                number += message;
                value = String.valueOf(number);
                break;
            case BYTE:
                handlePrimitive("" + message);
                break;
            case UNDEFINED:
                value = "" + message;
                break;
        }
        type = Type.INTEGER;
    }

    public static void log(byte message) {
        switch (type) {
            case STRING:
                handleString("" + message);
                break;
            case INTEGER:
                handlePrimitive("" + value);
                break;
            case BYTE:
                byte number = Byte.parseByte(value);
                // TODO make general method for both int and byte
                if (number + (int)message > Byte.MAX_VALUE) {
                    printToOutput("primitive: " + number);
                    printToOutput("primitive: " + message);
                }
                number += message;
                value = "" + number;
                break;
            case UNDEFINED:
                value = "" + message;
                break;
        }
        type = Type.BYTE;
    }

    public static void log(char message) {
        printToOutput("char: " + message);
    }

    public static void log(String message) {
        switch (type) {
            case STRING:
                // TODO separate method for unifying level of abstraction
                if (message.equals(value)) {
                    counter++;
                } else {
                    handleString(message);
                    counter = 1;
                }
                break;
            case INTEGER:
            case BYTE:
                handlePrimitive(message);
                counter = 1;
                break;
            case UNDEFINED:
                value = "" + message;
                break;
        }
        type = Type.STRING;
    }

    public static void log(boolean message) {
        printToOutput("boolean: " + message);
    }

    public static void log(Object message) {
        if (message == null) {
            printToOutput("null");
            return;
        }
        printToOutput("reference: " + message.toString());
    }

    private static void handleString(String newValue) {
        if (counter > 1) {
            printToOutput("string: " + value + " (x" + counter + ")");
        } else {
            printToOutput("string: " + value);
        }
        value = newValue;
        counter = 0;
    }
    //TODO make name more informative
    private static void handlePrimitive(String newValue) {
        printToOutput("primitive: " + value);
        value = newValue;
    }

    private static void handleValue(String newValue) {
        printToOutput(value);
        value = newValue;
    }

    private static void printToOutput(String message) {
        out.println(message);
    }
}
