package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {

    private static final LoggerController loggerController = new LoggerController(new ConsoleSaver());

    /**
     * Save decorated message, which is accumulated until this moment
     *
     * @see LoggerController
     */
    public static void postProcessing() {
        loggerController.postProcessing();
    }

    /**
     * Accumulate the content of messages of same type (int)
     * Flush the accumulated value on type switch
     * Decorate the message with prefix
     * Save decorated message to Saver
     *
     * @param message
     */
    public static void log(int message) {
      loggerController.log(new IntMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (byte)
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param message
     */
    public static void log(byte message) {
        loggerController.log(new ByteMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (char)
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param message
     */
    public static void log(char message) {
        loggerController.log(new CharMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (String)
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param message
     */
    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (boolean)
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param message
     */
    public static void log(boolean message) {
        loggerController.log(new BooleanMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (Object)
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param message
     */
    public static void log(Object message) {
        loggerController.log(new ObjectMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (int[])
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param intArray
     */
    public static void log(int[] intArray) {
        loggerController.log(new ArrayMessage(intArray));
    }

    /**
     * Accumulate the content of messages of same type (int[][])
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param matrix
     */
    public static void log(int[][] matrix) {
        loggerController.log(new MatrixMessage(matrix));
    }

    /**
     * Clears all previous message states
     */
    public static void clearLogger() { loggerController.clearLoggerMassageCash(); }
}
