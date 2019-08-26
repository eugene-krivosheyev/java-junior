package com.acme.edu;

import com.acme.edu.commands.*;

public class Logger {
    private static final String PRIMITIVES_PREFIX = "primitives ";
    public static final String PR_ARRAY_PREFIX = PRIMITIVES_PREFIX + "array: ";
    public static final String PR_MATRIX_PREFIX = PRIMITIVES_PREFIX + "matrix: ";
    public static final String PR_MULTIMATRIX_PREFIX = PRIMITIVES_PREFIX + "multimatrix: ";

    private static final Saver saver = new ConsoleSaver();
    private static final LoggerController loggerController = new LoggerController(saver);

    public static void log(byte message) {
        Command command = new ByteCommand(message);
        loggerController.log(command);
    }

    public static void log(int message) {
        Command command = new IntCommand(message);
        loggerController.log(command);
    }

    public static void log(String message) {
        Command command = new StringCommand(message);
        loggerController.log(command);
    }

    public static void log(int[] array) {
        saver.save(PR_ARRAY_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(int[][] array) {
        saver.save(PR_MATRIX_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void flush() {
        loggerController.flush();
    }
}
