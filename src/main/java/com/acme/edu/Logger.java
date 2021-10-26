package com.acme.edu;

import com.acme.edu.message.type.arrays.*;
import com.acme.edu.message.type.*;
import com.acme.edu.printer.Printer;

public class Logger {
    private static final Controller logger = new Controller(new Printer());

    private static boolean isSumming = false;

    public static void setSumming(boolean isSum){
        isSumming = isSum;
    }

    public static void log(int message) {
        logger.logMessage(new IntMessage(message,isSumming));
    }

    public static void log(int... message) {
        logger.logMessage(new IntArrayMessage(message,isSumming));
    }

    public static void log(int[]... message) {
        logger.logMessage(new IntMatrixMessage(message,isSumming));
    }

    public static void log(int[][]... message) {
        logger.logMessage(new IntCubeMessage(message,isSumming));
    }

    public static void log(int[][][]... message) {
        logger.logMessage(new IntMultiMatrixMessage(message,isSumming));
    }

    public static void log(char message) {
        logger.logMessage(new CharMessage(message));
    }

    public static void log(byte message) {
        logger.logMessage(new ByteMessage(message,isSumming));
    }

    public static void log(String message) {
        logger.logMessage(new StringMessage(message,isSumming));
    }

    public static void log(String... message) {
        logger.logMessage(new StringArrayMessage(message,isSumming));
    }

    public static void log(Boolean message) {
        logger.logMessage(new BoolMessage(message));
    }

    public static void log(Object message) {
        logger.logMessage(new ObjectMessage(message));
    }

    public static void log(){
        logger.endLogging(true);
    }
}
