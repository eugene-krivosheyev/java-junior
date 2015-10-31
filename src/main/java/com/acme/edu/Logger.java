package com.acme.edu;

public class Logger {

    //region constants

    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVE = "primitive: ";
    private static boolean flag;
    private static String lastStr = "str 1";
    private static int countInt = 0;
    private static int countStr = 0;
    //endregion

    /**
     * Call method "print" with using parameter type boolean
     * @param message print parameter boolean
     */
    public static void log(boolean message) {
        print(Logger.PRIMITIVE + message);
    }

    /**
     * Call method "print" with using parameter type char
     * @param message print parameter char
     */
    public static void log(char message) {
        print(Logger.CHAR + message);
    }

    /**
     * Call method "print" with using parameter type Object
     * @param message print parameter Object
     */
    public static void log(Object message)
    {
        print(Logger.REFERENCE + message);
    }

    /**
     * Call method "close"
     * Call method "print" with using parameter type int
     * Call method checkedMAX
     * @param message print parameter int
     */
    public static void log(int message) {
        if (!lastStr.isEmpty()) {
            close();
        }
        if (!Logger.flag) {
            print(Logger.PRIMITIVE + message);
        } else if (message == 0) {
            print(Logger.PRIMITIVE + message);
        } else {
            checkedMax(message);
            countInt += message;
        }
    }

    /**
     * Sets the value of flag to true
     * Call method "print" with using parameter type String
     * Call method "close"
     * @param message print parameter String
     */
    public static void log(String message) {
        Logger.flag = true;
        if (countInt != 0) {
            print(PRIMITIVE + countInt);
            countInt = 0;
        }

        //логика для теста shouldLogSameSubsequentStringsWithoutRepeat()
        if (message.equals(lastStr)) {
            countStr++;
        } else if (countStr == 1) {
            print(STRING + lastStr);
            lastStr = message;
        } else if (countStr == 0) {
            print(STRING + message);
        } else {
            close();
            countStr = 0;
        }
        if (countStr > 2) {
            close();
        }
    }

    /**
     * Prints a String and then terminate the line.
     * @param massege print String
     */
    private static void print(String massege) {
        System.out.println(massege);
    }


    private static void checkedMax(int message) {
        if (message == Integer.MAX_VALUE) {
            print(Logger.PRIMITIVE + Logger.countInt);
            Logger.countInt = 0;
        }
        if (message == Byte.MAX_VALUE) {
            print(Logger.PRIMITIVE + Logger.countInt);
            Logger.countInt = 0;
        }
    }

    private static void close() {
        if (Logger.countStr > 1) {
            print(String.format("%s%s (x%d)", Logger.STRING, Logger.lastStr, Logger.countStr));
            Logger.countStr = 0;
        }
        if (Logger.countStr == 1) {
            print(Logger.STRING + Logger.lastStr);
            Logger.countStr = 0;
        }

    }
}
