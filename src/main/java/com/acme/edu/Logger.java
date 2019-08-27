package com.acme.edu;

import com.acme.edu.commands.*;

/**
 * JavaDoc comment
 * Class Logger has unnecessarily comment.
 * <strong>bold</strong>
 *
 * @see java.lang.String#String()
 */
public class Logger {
    private static LoggerController loggerController;

    static {
        SuperSaver saver = new ConcoleSaver();
        loggerController = new LoggerController(saver);
    }

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

    public static void flush() {
        loggerController.flush();
    }
}