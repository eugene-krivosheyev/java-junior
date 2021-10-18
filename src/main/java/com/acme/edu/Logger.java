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

    static private String stringValue;
    static private int intValue;
    static private byte byteValue;

    static Type type = Type.UNDEFINED;
    static int counter = 0;


    // TODO: flush
    public static void flash() {
        processPreviousValue(Type.UNDEFINED);
        stringValue = "";
        intValue = 0;
        byteValue = 0;
    }

    private static boolean processPreviousValue(Type currentType) {
        if (currentType.equals(type)) {
            return false;
        }
        switch (type) {
            case STRING:
                handleString();
                counter = 0;
                break;
            case INTEGER:
                handleInt();
                break;
            case BYTE:
                handleByte();
                break;
        }
        type = currentType;
        return true;
    }

    public static void setPrintStream(PrintStream newPrintStream) {
        out = newPrintStream;
    }

    public static void log(int message) {
        if (processPreviousValue(Type.INTEGER)) {
            intValue = message;
        } else {
            if (intValue + (long)message > Integer.MAX_VALUE) {
                printToOutput("primitive: " + intValue);
                printToOutput("primitive: " + message);
            }
            intValue += message;
        }
    }

    public static void log(byte message) {
        if (processPreviousValue(Type.BYTE)) {
            byteValue = message;
        } else {
            // TODO make general method for both int and byte
            if (byteValue + (int)message > Byte.MAX_VALUE) {
                printToOutput("primitive: " + byteValue);
                printToOutput("primitive: " + message);
            }
            byteValue += message;
        }
    }

    public static void log(char message) {
        printToOutput("char: " + message);
    }

    public static void log(String message) {
        if (processPreviousValue(Type.STRING)) {
            stringValue = String.valueOf(message);
        } else {
            // TODO separate method for unifying level of abstraction
            if (message.equals(stringValue)) {
                counter++;
            } else {
                handleString();
                stringValue = message;
                counter = 1;
            }
        }
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

    public static void log(int... array) {
        printToOutput("arrays's sum: " + getSumOfArray(array));
    }
    public static void log(int[]... array) {
        int sum = 0;
        for (int[] subArray: array) {
            sum += getSumOfArray(subArray);
        }
        printToOutput("matrix sum: " + sum);
    }
    public static void log(String... array) {
        for (String value: array) {
            log(value);
        }
    }

    private static int getSumOfArray(int... array) {
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }

    private static void handleString() {
        if (counter > 1) {
            printToOutput("string: " + stringValue + " (x" + counter + ")");
        } else {
            printToOutput("string: " + stringValue);
        }
        counter = 0;
    }
    //TODO make name more informative
    private static void handleByte() {
        printToOutput("primitive: " + byteValue);
    }
    private static void handleInt() {
        printToOutput("primitive: " + intValue);
    }

    private static void printToOutput(String message) {
        out.println(message);
    }
}
