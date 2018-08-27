package com.acme.edu;

/*
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
}
*/

public class Logger {
    public static Controller controller = new Controller(new ConsolSaver());


    /*public static void main(String[] args) {
        Logger.log(1);
        Logger.flush();
    }*/

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public static void log(int[] message) {

    }

    public static void log(int[][] message) {

    }

    public static void flush() {
        controller.flush();
    }

}