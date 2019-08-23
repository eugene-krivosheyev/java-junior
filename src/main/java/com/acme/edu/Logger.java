package com.acme.edu;


public class Logger {

    static LoggerController loggerController = new LoggerController();

    public static final String DELIMETER = ", ";

    public static void flush() {
        loggerController.flush();
    }

    // region Log methods
    public static void log(String message) {
        loggerController.log(new StringCommand(message));
    }

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

//    public static void log(byte message) {
//        loggerController.log(new ByteCommand(message));
//    }

//    public static void log(boolean message) {
//        flushBufferAndChangeTypeIfNeeded(Type.BOOLEAN);
//        decorateAndPrintPrimitive(String.valueOf(message));
//    }
//
//    public static void log(char message) {
//        flushBufferAndChangeTypeIfNeeded(Type.CHAR);
//        decorateAndPrintChar(String.valueOf(message));
//    }
//
//    public static void log(Object message) {
//        flushBufferAndChangeTypeIfNeeded(Type.OBJECT);
//        decorateAndPrintObject(String.valueOf(message));
//    }
//
//    public static void log(int[] array) {
//        flushBufferAndChangeTypeIfNeeded(Type.ARRAY);
//        decorateAndPrintArray(convertArrayToString(array));
//    }
//
//    public static void log(int[][] matrix) {
//        flushBufferAndChangeTypeIfNeeded(Type.MATRIX);
//        decorateAndPrintMatrix(convertMatrixToString(matrix));
//    }
//
//    public static void log(String... strings) {
//        for(String str : strings) {
//            flushBufferAndChangeTypeIfNeeded(Type.STRING);
//            accumulate(str);
//        }
//    }
    // endregion
//
//    private static String convertArrayToString(int[] array) {
//        String temp = "{";
//        for (int i = 0; i < array.length - 1; i++) {
//            temp += array[i] + DELIMETER;
//        }
//        temp += array[array.length - 1] + "}";
//        return temp;
//
//    }
//
//    private static String convertMatrixToString(int[][] matrix) {
//        String temp = "{\n";
//        for (int[] array : matrix) {
//            temp += convertArrayToString(array) + "\n";
//        }
//        temp += "}";
//        return temp;
//    }

    // endregion

}
