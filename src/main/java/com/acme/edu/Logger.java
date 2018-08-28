package com.acme.edu;

import com.acme.edu.message.*;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void flush() {
        loggerController.flush();
    }

    public static void log(int[][] message) {
        Message currentMatrixMessage = new MatrixMessage(message);
        loggerController.log(currentMatrixMessage);
    }

    public static void log(int[] message) {
        Message currentArray1DMessage = new Array1DMessage(message);
        loggerController.log(currentArray1DMessage);
    }

    public static void log(Object message) {
        Message currentObjectMessage = new ObjectMessage(message);
        loggerController.log(currentObjectMessage);
    }

    public static void log(boolean message) {
        Message currentBooleanMessage = new BooleanMessage(message);
        loggerController.log(currentBooleanMessage);
    }

    public static void log(char message) {
        Message currentCharMessage = new CharMessage(message);
        loggerController.log(currentCharMessage);
    }

    public static void log(String message) {
        Message currentStringMessage = new StringMessage(message);
        loggerController.log(currentStringMessage);
    }

    public static void log(int message) {
        Message currentIntMessage = new IntMessage(message);
        loggerController.log(currentIntMessage);
    }
}