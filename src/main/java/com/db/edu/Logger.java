package com.db.edu;

public class Logger {

    private static int intSum = 0;
    private static int intCount = 0;
    private static String stringAcc = "";
    private static int stringCount = 0;

    public static void printToConsole(String message) {
        System.out.println(message);
    }

    public static void log(int message) {
        printAccumulatedString();
        if (isOverflows(message) == 0) {
            intCount++;
            intSum += message;
        } else if (isOverflows(message) == 1) {
            printOverflow(message, Integer.MAX_VALUE);
        } else if (isOverflows(message) == -1) {
            printOverflow(message, Integer.MIN_VALUE);
        }
    }

    public static void log(int... message) {
        printAccumulatedString();
        for (int current : message) {
            if (isOverflows(current) == 0) {
                intCount++;
                intSum += current;
            } else if (isOverflows(current) == 1) {
                printOverflow(current, Integer.MAX_VALUE);
            } else if (isOverflows(current) == -1) {
                printOverflow(current, Integer.MIN_VALUE);
            }
        }
    }


    public static void log(byte message) {
        printAccumulatedInt();
        printAccumulatedString();
        printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void log(char message) {
        printAccumulatedInt();
        printAccumulatedString();
        printToConsole(Prefix.CHAR.value + message);
    }

    public static void log(String message) {
        printAccumulatedInt();
        if (stringCount > 0 && !stringAcc.equals(message)) {
            printAccumulatedString();
        }
        stringAcc = message;
        stringCount++;
    }

    public static void log(String... message) {
        printAccumulatedInt();
        for (String current : message) {
            if (stringCount > 0 && !stringAcc.equals(current)) {
                printAccumulatedString();
            }
            stringAcc = current;
            stringCount++;
        }
    }

    public static void log(boolean message) {
        printAccumulatedString();
        printAccumulatedInt();
        printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void log(Object message) {
        printAccumulatedInt();
        printAccumulatedString();
        printToConsole(Prefix.PRIMITIVE.value + message);
    }

    public static void close() {
        printAccumulatedInt();
        printAccumulatedString();
    }

    private static void printAccumulatedInt() {
        if (intCount != 0) {
            printToConsole(Prefix.PRIMITIVE.value + intSum);
            intCount = 0;
            intSum = 0;
        }
    }

    private static void printAccumulatedString() {
        if (stringCount != 0) {
            printToConsole(Prefix.STRING + stringAcc + (stringCount > 1 ? " (x" + stringCount + ")" : ""));
            stringCount = 0;
            stringAcc = "";
        }
    }

    private static int isOverflows(int message) {
        if (message >= 0 && intSum >= 0 && message + intSum < 0) return 1;
        else if (message <= 0 && intSum <= 0 && message + intSum > 0) return -1;
        else return 0;
    }

    private static void printOverflow(int message, int constant) {
        int temp = message + intSum - constant;
        intSum = constant;
        printAccumulatedInt();
        if (temp != 0) {
            intSum = temp;
            intCount = 1;
        }
    }
}
