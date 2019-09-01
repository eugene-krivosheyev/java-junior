package com.acme.edu;

import commands.*;

public class Logger {


    private static LoggerController logger = new LoggerController(new FileSaver(10, 10));

    public static void log(int message) {
        logger.log(new IntCommand(message));
    }

    public static void log(byte message) {
        logger.log(new ByteCommand(message));
    }

    public static void log(char message) {
        logger.log(new CharCommand(message));
    }

    public static void log(String message) {
        logger.log(new StringCommand(message, 0));
    }

    public static void log(Boolean message) {
        logger.log(new BooleanCommand(message));
    }

    public static void log(Object... array) {
        logger.log(new ArrayCommand(array));
    }

    public static void log(int[][] matrix) {
        logger.log(new MatrixCommand(matrix));
    }

    public static void log(int[][][][] multiDimMatrix) {
        logger.log(new MultiDimMatrixCommand(multiDimMatrix));
    }

    public static void log(Object message) {
        logger.log(new ReferenceCommand(message));
    }


    private static void flushBuffer() {
        logger.flush();

    }

    public static void flush() {
        flushBuffer();

    }

}
