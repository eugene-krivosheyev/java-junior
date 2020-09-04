package com.acme.edu;

public class Logger {

    private static String primitiveType = "primitive: ";

    private static String charType = "char: ";

    private static String stringType = "string: ";

    private static String referenceType = "reference: ";

    private static void printMessage(String message) {
        System.out.print(message);
    }

    private static void printBuffer() {
        switch (last) {
            case INTEGER:
                printMessage(primitiveType + savedInt);
                break;
            case BYTE:
                printMessage(primitiveType + savedByte);
                break;
            case STRING:
                printMessage(stringType + savedString);
                if(stringCounter != 1){
                    System.out.print(" (x" + stringCounter + ")");
                }
                break;
        }
        System.out.println();
    }

    private static void resetBuffer() {
        savedString = "";
        savedInt = 0;
        savedByte = 0;
        stringCounter = 0;
    }

    static int savedInt = 0;
    static String savedString = "";
    static byte savedByte = 0;
    static types last = null;
    static int stringCounter = 0;

    enum types {
        INTEGER ,
        BYTE ,
        STRING
    }

    public static void main(String[] args) {
        log("a");
        log("b");
        log("b");
        log("a");
        log("a");
        flush();
    }

    public static void flush() {
        printBuffer();
        resetBuffer();
    }

    public static void log(int message) {
        if (last != types.INTEGER && last != null) {
            printBuffer();
            resetBuffer();
        }
        long safe = savedInt;
        safe += message;
        if(safe > Integer.MAX_VALUE){
            printBuffer();
            resetBuffer();
            savedInt = message;
        }
        else {
            savedInt += message;
        }
        last = types.INTEGER;
    }

    public static void log(byte message) {
        if (last != types.BYTE && last != null) {
            printBuffer();
            resetBuffer();
        }
        savedByte += message;
        last = types.BYTE;
    }

    public static void log(char message) {
        printMessage(charType + message);
    }

    public static void log(String message) {
        if ((last != types.STRING && last != null) || (savedString != message && last != null)) {
            printBuffer();
            resetBuffer();
        }
        savedString = message;
        stringCounter++;
        last = types.STRING;
    }

    public static void log(boolean message) {
        printMessage(primitiveType + message);
    }

    public static void log(Object message) {
        printMessage(referenceType + message);
    }
}
