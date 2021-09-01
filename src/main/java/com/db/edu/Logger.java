package com.db.edu;

import com.db.edu.Message.*;
import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Save.FileSaver;
import com.db.edu.Save.SaveException;

public class Logger {

    public static LoggerController loggerController = new LoggerController(new FileSaver());

    public static void log(int message) throws SaveException {
        loggerController.log(new IntMessage(message));
    }

    public static void log(int... message) throws SaveException {
        for (int current : message) {
            loggerController.log(new IntMessage(current));
        }
    }

    public static void log(byte message) throws SaveException {
        loggerController.log(new ByteMessage(message));
    }

    public static void log(char message) throws SaveException {
        loggerController.log(new CharMessage(message));
    }

    public static void log(String message) throws SaveException {
        loggerController.log(new StringMessage(message));
    }

    public static void log(String... message) throws SaveException {
        for (String current : message) {
            loggerController.log(new StringMessage(current));
        }
    }

    public static void log(boolean message) throws SaveException {
        loggerController.log(new BoolMessage(message));
    }

    public static void log(Object message) throws SaveException {
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
