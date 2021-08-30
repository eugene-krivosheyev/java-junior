package com.db.edu;

import com.db.edu.Message.*;
import com.db.edu.Save.ConsoleSaver;

public class Logger {

    public static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }

    public static void log(int... message) {
        for (int current : message) {
            loggerController.log(new IntMessage(current));
        }
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

    public static void log(String... message) {
        for (String current : message) {
            loggerController.log(new StringMessage(current));
        }
    }

    public static void log(boolean message) {
        loggerController.log(new BoolMessage(message));
    }

    public static void log(Object message) {
        loggerController.log(new ObjectMessage(message));
    }

    /*
    private static int isOverflows(int message) {
        if (message >= 0 && LoggerController.intSum >= 0 && message + LoggerController.intSum < 0) return 1;
        else if (message <= 0 && LoggerController.intSum <= 0 && message + LoggerController.intSum > 0) return -1;
        else return 0;
    }

    private static void printOverflow(int message, int constant) {
        int temp = message + LoggerController.intSum - constant;
        LoggerController.intSum = constant;
        IntMessage.printAccumulatedInt();
        if (temp != 0) {
            LoggerController.intSum = temp;
            LoggerController.intCount = 1;
        }
    }
    */
}
