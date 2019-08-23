package com.acme.edu;

import java.util.Arrays;

import static com.acme.edu.Constants.*;

/**
 * JavaDoc comment
 * Class Logger has unnecessarily comment.
 * <strong>bold</strong>
 *
 * @see java.lang.String#String()
 */
public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteCommand(message));
    }

    public static void log(boolean message) {
        loggerController.log(new BooleanCommand(message));
    }

    public static void log(char message) {
        loggerController.log(new CharCommand(message));
    }

    public static void log(String message)
    {
        loggerController.log(new StringCommand(message));
    }

    public static void log(Object message) {
        loggerController.log(new ObjectCommand(message));
    }

    public static void log(int[] message) {
        loggerController.log(new ArrayCommand(message));
    }

    public static void log(int[][] message) {
        loggerController.log(new MatrixCommand(message));
    }

    public static void log(int[][][][] message) {
        loggerController.log(new MultiMatrixCommand(message));
    }

    private static String decoratePrimitive(String message) {
        return PRIMITIVE_PREFIX + message;
    }

    private static void save(String message) {
        System.out.println(message);
    }

}