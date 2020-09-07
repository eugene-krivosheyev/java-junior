package com.acme.edu;

public class Logger {

    private static final LoggerController loggerController = new LoggerController();

    public static void postProcessing() {
        loggerController.printLastUpdatedType();
    }

    public static void log(int message) {
      loggerController.log(message);
    }

    public static void log(byte message) {
        loggerController.log(message);
    }

    public static void log(char message) {
        loggerController.log(message);
    }

    public static void log(String message) {
        loggerController.log(message);
    }

    public static void log(boolean message) {
        loggerController.log(message);
    }

    public static void log(Object message) {
        loggerController.log(message);
    }

    public static void log(int[] intArray) {
        loggerController.log(intArray);
    }

    public static void log(int[][] matrix) {
        loggerController.log(matrix);
    }
}
