package com.db.edu;

public class Logger {

    static LoggerController loggerController = new LoggerController();

    public static void log(int message) {
        loggerController.log(new IntMessage(message));
    }

    public static void log(int... message) {
        StringMessage.printAccumulatedString();
        for (int current : message) {
            loggerController.log(new IntMessage(current));
        }
    }

    public static void log(byte message) {
        IntMessage.printAccumulatedInt();
        StringMessage.printAccumulatedString();
        ConsoleSaver.printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void log(char message) {
        IntMessage.printAccumulatedInt();
        StringMessage.printAccumulatedString();
        ConsoleSaver.printToConsole(Prefix.CHAR.value + message);
    }

    public static void log(String message) {
        IntMessage.printAccumulatedInt();
        loggerController.log(new StringMessage(message));
    }

    public static void log(String... message) {
        IntMessage.printAccumulatedInt();
        for (String current : message) {
            loggerController.log(new StringMessage(current));
        }
    }

    public static void log(boolean message) {
        StringMessage.printAccumulatedString();
        IntMessage.printAccumulatedInt();
        ConsoleSaver.printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void log(Object message) {
        IntMessage.printAccumulatedInt();
        StringMessage.printAccumulatedString();
        ConsoleSaver.printToConsole(Prefix.REFERENCE.value + message);
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
