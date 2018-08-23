package com.acme.edu;

//TODO To think
public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";
    private static final String CHAR = "char";
    private  static final String LINE_SEPARATOR = ": ";
    private static final String INTEGER = "int";
    private static final String BYTE = "byte";
    private static final String PRIMITIVE_ARRAY = "primitives array";
    private static final String PRIMITIVE_MATRIX = "primitives matrix";

    private static String loggerMessageType = "";
    private static int sequentNumberSum = 0;
    private static String currentString = "";
    private static int numOfStringRepetions = 0;
    private static String bufferForFlush;

    public static void log(int message) {
        if (!loggerMessageType.equals(INTEGER)) {
            Logger.flushAndChangeType(INTEGER);
            sequentNumberSum = 0;
        }
        long ifOverflow = (long) sequentNumberSum + message;
        if (ifOverflow > Integer.MAX_VALUE || ifOverflow < Integer.MIN_VALUE) {
            Logger.flushAndChangeType(INTEGER);
            sequentNumberSum = 0;
        }
        sequentNumberSum += message;
        bufferForFlush = PRIMITIVE + LINE_SEPARATOR + sequentNumberSum;
    }

    public static void log(byte message) {
        if (!loggerMessageType.equals(BYTE)) {
            Logger.flushAndChangeType(BYTE);
            sequentNumberSum = 0;
        }
        long ifOverflow = (long) sequentNumberSum + message;
        if (ifOverflow > Byte.MAX_VALUE || ifOverflow < Byte.MIN_VALUE) {
            Logger.flushAndChangeType(BYTE);
            sequentNumberSum = 0;
        }
        sequentNumberSum += message;
        bufferForFlush = PRIMITIVE + LINE_SEPARATOR + sequentNumberSum;
    }

    public static void log(boolean message) {
        Logger.flushAndChangeType(PRIMITIVE);
        bufferForFlush = loggerMessageType + LINE_SEPARATOR + message;
    }

    public static void log(char message) {
        Logger.flushAndChangeType(CHAR);
        bufferForFlush = loggerMessageType + LINE_SEPARATOR + message;
    }

    public static void log(String message) {
        if (!loggerMessageType.equals(STRING) || !currentString.equals(message)) {
            Logger.flushAndChangeType(STRING);
            numOfStringRepetions = 0;
            currentString = message;
        }
        numOfStringRepetions++;
        bufferForFlush = loggerMessageType + LINE_SEPARATOR + currentString + " (x" + numOfStringRepetions + ")";
    }

    public static void log(Object message) {
        Logger.flushAndChangeType(REFERENCE);
        bufferForFlush = loggerMessageType + LINE_SEPARATOR + message;
    }

    public static void log(int[] message) {
        Logger.flushAndChangeType(PRIMITIVE_ARRAY);
        bufferForFlush = loggerMessageType + LINE_SEPARATOR;
        addArrayToBuffer(message);
    }

    public static void log(int[][] message) {
        Logger.flushAndChangeType(PRIMITIVE_MATRIX);
        bufferForFlush = loggerMessageType + LINE_SEPARATOR + "{" + System.lineSeparator();
        for (int outerCurrent = 0; outerCurrent < message.length; outerCurrent++) {
            addArrayToBuffer(message[outerCurrent]);
            bufferForFlush += System.lineSeparator();
        }
        bufferForFlush += "}";
    }

    public static void addArrayToBuffer(int[] message) {
        bufferForFlush += "{";
        for (int current = 0; current < message.length-1; current++) {
            bufferForFlush += message[current] + ", ";
        }
        if (message.length > 0) {
            bufferForFlush += message[message.length-1];
        }
        bufferForFlush += "}";
    }

    public static void printOutputToConsole(String message) {
        System.out.println(message);
    }

    public static void flushAndChangeType(String type) {
        Logger.flush();
        loggerMessageType = type;
    }

    public static void flush() {
        if (loggerMessageType.equals("")) return;
        System.out.println(bufferForFlush);
        loggerMessageType = "";
    }
}
