package com.db.edu;

public class Logger {

    public static void log(int message) {
        LoggerController.printAccumulatedString();
        if (isOverflows(message) == 0) {
            LoggerController.intCount++;
            LoggerController.intSum += message;
        } else if (isOverflows(message) == 1) {
            printOverflow(message, Integer.MAX_VALUE);
        } else if (isOverflows(message) == -1) {
            printOverflow(message, Integer.MIN_VALUE);
        }
    }

    public static void log(int... message) {
        LoggerController.printAccumulatedString();
        for (int current : message) {
            if (isOverflows(current) == 0) {
                LoggerController.intCount++;
                LoggerController.intSum += current;
            } else if (isOverflows(current) == 1) {
                printOverflow(current, Integer.MAX_VALUE);
            } else if (isOverflows(current) == -1) {
                printOverflow(current, Integer.MIN_VALUE);
            }
        }
    }


    public static void log(byte message) {
        LoggerController.printAccumulatedInt();
        LoggerController.printAccumulatedString();
        ConsoleSaver.printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void log(char message) {
        LoggerController.printAccumulatedInt();
        LoggerController.printAccumulatedString();
        ConsoleSaver.printToConsole(Prefix.CHAR.value + message);
    }

    public static void log(String message) {
        LoggerController.printAccumulatedInt();
        if (LoggerController.stringCount > 0 && !LoggerController.stringAcc.equals(message)) {
            LoggerController.printAccumulatedString();
        }
        LoggerController.stringAcc = message;
        LoggerController.stringCount++;
    }

    public static void log(String... message) {
        LoggerController.printAccumulatedInt();
        for (String current : message) {
            if (LoggerController.stringCount > 0 && !LoggerController.stringAcc.equals(current)) {
                LoggerController.printAccumulatedString();
            }
            LoggerController.stringAcc = current;
            LoggerController.stringCount++;
        }
    }

    public static void log(boolean message) {
        LoggerController.printAccumulatedString();
        LoggerController.printAccumulatedInt();
        ConsoleSaver.printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void log(Object message) {
        LoggerController.printAccumulatedInt();
        LoggerController.printAccumulatedString();
        ConsoleSaver.printToConsole(Prefix.REFERENCE.value + message);
    }

    private static int isOverflows(int message) {
        if (message >= 0 && LoggerController.intSum >= 0 && message + LoggerController.intSum < 0) return 1;
        else if (message <= 0 && LoggerController.intSum <= 0 && message + LoggerController.intSum > 0) return -1;
        else return 0;
    }

    private static void printOverflow(int message, int constant) {
        int temp = message + LoggerController.intSum - constant;
        LoggerController.intSum = constant;
        LoggerController.printAccumulatedInt();
        if (temp != 0) {
            LoggerController.intSum = temp;
            LoggerController.intCount = 1;
        }
    }
}
