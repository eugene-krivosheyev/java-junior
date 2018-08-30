package com.acme.edu;

import com.acme.edu.message.*;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static int flush() {
        try {
            loggerController.flush();
        } catch (FlushException e) {
            return 100;
        }
        return 0;
    }

    public static int log(int[][] message) {
        Message currentMatrixMessage = new MatrixMessage(message);
        try {
            loggerController.log(currentMatrixMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }

    public static int log(int[] message) {
        Message currentArray1DMessage = new Array1DMessage(message);
        try {
            loggerController.log(currentArray1DMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }

    public static int log(Object message) {
        Message currentObjectMessage = new ObjectMessage(message);
        try {
            loggerController.log(currentObjectMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }

    public static int log(boolean message) {
        Message currentBooleanMessage = new BooleanMessage(message);
        try {
            loggerController.log(currentBooleanMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }

    public static int log(char message) {
        Message currentCharMessage = new CharMessage(message);
        try {
            loggerController.log(currentCharMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }

    public static int log(String message) {
        Message currentStringMessage = new StringMessage(message);
        try {
            loggerController.log(currentStringMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }

    public static int log(int message) {
        Message currentIntMessage = new IntMessage(message);
        try {
            loggerController.log(currentIntMessage);
        } catch (Exception e) {
            return 200;
        }
        return 0;
    }
}