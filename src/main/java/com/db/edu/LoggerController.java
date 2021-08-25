package com.db.edu;

public class LoggerController {

    static int intSum = 0;
    static int intCount = 0;
    static String stringAcc = "";
    static int stringCount = 0;

    static void printAccumulatedInt() {
        if (intCount != 0) {
            ConsoleSaver.printToConsole(Prefix.PRIMITIVE.value + intSum);
            intCount = 0;
            intSum = 0;
        }
    }

    static void printAccumulatedString() {
        if (stringCount != 0) {
            ConsoleSaver.printToConsole(Prefix.STRING.value + stringAcc + (stringCount > 1 ? " (x" + stringCount + ")" : ""));
            stringCount = 0;
            stringAcc = "";
        }
    }

    public static void close() {
        printAccumulatedInt();
        printAccumulatedString();
    }

    public void log(Message message) {

    }
}
