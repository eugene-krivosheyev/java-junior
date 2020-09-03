package com.acme.edu;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0.2
 */
public class Logger {
    static String logMessage;
    static final String CHAR_PREFIX = "char: ";
    static final String STRING_PREFIX = "string: ";
    static final String REFERENCE_PREFIX = "reference: ";
    static final String PRIMITIVE_PREFIX = "primitive: ";

    private static void writeMessage() {
        System.out.println(logMessage);
    }

    /**
     * @param  message  an integer value to be logged
     */
    public static void log(int message) {
        logMessage = PRIMITIVE_PREFIX + message;
        writeMessage();
    }

    /**
     * @param  message  a byte value to be logged
     */
    public static void log(byte message) {
        logMessage = PRIMITIVE_PREFIX + message;
        writeMessage();
    }

    /**
     * @param message a Boolean value to be logged
     */
    public static void log(boolean message) {
        logMessage = PRIMITIVE_PREFIX + message;
        writeMessage();
    }

    /**
     * @param  message  a char value to be logged
     */
    public static void log(char message) {
        logMessage = CHAR_PREFIX + message;
        writeMessage();
    }

    /**
     * @param  message  a String value to be logged
     */
    public static void log(String message) {
        logMessage = STRING_PREFIX + message;
        writeMessage();
    }

    /**
     * @param message an Object value to be logged
     */
    public static void log(Object message) {
        logMessage = REFERENCE_PREFIX + message;
        writeMessage();
    }
}