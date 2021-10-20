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

    static private String stringValue;
    static private int intValue;
    static private byte byteValue;

    static Type type = Type.UNDEFINED;
    static int counter = 0;

    static LoggerController controller = new LoggerController();


    public static void flush() {
        /*processPreviousValue(Type.UNDEFINED);
        stringValue = "";
        intValue = 0;
        byteValue = 0;*/
        controller.flush();

    }

    private static boolean processPreviousValue(Type currentType) {
        if (currentType.equals(type)) {
            return false;
        }
        switch (type) {
            case STRING:
                decorateString();
                counter = 0;
                break;
            case INTEGER:
                decorateInt();
                break;
            case BYTE:
                decorateByte();
                break;
        }
        type = currentType;
        return true;
    }

    public static void setPrintStream(PrintStream newPrintStream) {
        out = newPrintStream;
    }

    public static void log(int message) {
        /*if (processPreviousValue(Type.INTEGER)) {
            intValue = message;
        } else {
            handleOverFlow(intValue, message, Integer.MAX_VALUE);
            intValue += message;
        }*/
        controller.log(message);
    }

    public static void log(byte message) {
        /*if (processPreviousValue(Type.BYTE)) {
            byteValue = message;
        } else {
            handleOverFlow(byteValue, message, Byte.MAX_VALUE);
            byteValue += message;
        }*/
        controller.log(message);
    }

    public static void log(char message) {
        printToOutput("char: " + message);
    }

    public static void log(String message) {
        /*if (processPreviousValue(Type.STRING)) {
            stringValue = message;
        } else {
            processRepeatedStringValue(message);
        }*/
        controller.log(message);
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

    private static void decorateString() {
        if (counter > 1) {
            printToOutput("string: " + stringValue + " (x" + counter + ")");
        } else {
            printToOutput("string: " + stringValue);
        }
        counter = 0;
    }

    private static void decorateByte() {
        printToOutput("primitive: " + byteValue);
    }

    private static void decorateInt() {
        printToOutput("primitive: " + intValue);
    }

    private static void printToOutput(String message) {
        out.println(message);
    }


    private static void handleOverFlow(int value, long message, int max) {

        if (value + message > max) {
            printToOutput("primitive: " + value);
            printToOutput("primitive: " + max);
        }

    }

    private static void processRepeatedStringValue(String message) {
        if (message.equals(stringValue)) {
            counter++;
        } else {
            decorateString();
            stringValue = message;
            counter = 1;
        }
    }

}
