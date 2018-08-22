package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";
    private static final String CHAR = "char";
    private  static final String lineSeparator = ": ";

    private static String state = "";
    private static int sum = 0;
    private  static String currentString = "";
    private  static int numOfStrings = 0;
    /*private static  boolean logBoolean;
    private static char logChar;
    private  static Object logObject;*/
    private static String buffer;

    public static void log(int message) {
       // printOutputToConsole(PRIMITIVE + message);
        if (!state.equals("int")) {
            Logger.flush();
            state = "int";
            sum = 0;
        }
        long ifOverflow = (long)sum + message;
        if (ifOverflow > Integer.MAX_VALUE || ifOverflow < Integer.MIN_VALUE) {
            Logger.flush();
            state = "int";
            sum = 0;
        }
        sum += message;
        buffer = PRIMITIVE + lineSeparator + sum;
    }

    public static void log(byte message) {
        //printOutputToConsole(PRIMITIVE + message);
        if (!state.equals("byte")) {
            Logger.flush();
            state = "byte";
            sum = 0;
        }
        long ifOverflow = (long)sum + message;
        if (ifOverflow > Byte.MAX_VALUE || ifOverflow < Byte.MIN_VALUE) {
            Logger.flush();
            state = "byte";
            sum = 0;
        }
        sum += message;
        buffer = PRIMITIVE + lineSeparator + sum;
    }

    public static void log(boolean message) {
        //printOutputToConsole(PRIMITIVE + message);
        Logger.flush();
        state = PRIMITIVE;
        buffer = state + lineSeparator + message;
    }

    public static void log(char message) {
        //printOutputToConsole(CHAR + message);
        Logger.flush();
        state = CHAR;
        buffer = state + lineSeparator + message;
    }

    public static void log(String message) {
        //printOutputToConsole(STRING + message);
        if (!state.equals(STRING) || !currentString.equals(message)) {
            Logger.flush();
            state = STRING;
            numOfStrings = 0;
            currentString = message;
        }
        numOfStrings++;
        buffer = state + lineSeparator + currentString + " (x" + numOfStrings + ")";
    }

    public static void log(Object message) {
        //printOutputToConsole(REFERENCE + message);
        Logger.flush();
        state = REFERENCE;
        buffer = state + lineSeparator + message;
    }

    public static void printOutputToConsole(String message) {
        System.out.println(message);
    }

    public  static void flush() {
        if (state.equals("")) return;
        System.out.println(buffer);
        state = "";
    }
}
