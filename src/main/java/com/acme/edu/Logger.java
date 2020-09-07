package com.acme.edu;

import com.acme.edu.message.*;

public class Logger {

    private static final LoggerController loggerController = new LoggerController();

    public static void postProcessing() {
        loggerController.postProcessing();
    }

    public static void log(int message) {
      loggerController.log(new IntMessage(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteMessage(message));
    }

    public static void log(char message) {
        loggerController.log(new CharMessage(message));
    }

    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        loggerController.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        loggerController.log(new ObjectMessage(message));
    }

    public static void log(int[] intArray) {
        loggerController.log(new ArrayMessage(intArray));
    }

    public static void log(int[][] matrix) {
        loggerController.log(new MatrixMessage(matrix));
    }

    public static void clearLogger() { loggerController.clearLoggerMassageCash(); }
}
