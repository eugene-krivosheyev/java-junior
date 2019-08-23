package com.acme.edu;


public class Logger {

    static LoggerController loggerController = new LoggerController();

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    public static final String DELIMETER = ", ";

    private enum Type {
        UNDEFINED(""),
        INTEGER(PRIMITIVE_PREFIX),
        BYTE(PRIMITIVE_PREFIX),
        BOOLEAN(PRIMITIVE_PREFIX),
        CHAR("char: "),
        STRING("string: "),
        OBJECT("reference: "),
        ARRAY("primitives array: "),
        MATRIX("primitives matrix: ");

        private String prefix;
        Type(String prefix){
            this.prefix = prefix;
        }
        public String getPrefix() {
            return prefix;
        }
    }

    private static Type currentType = Type.UNDEFINED;


    // region Log methods
    public static void log(String message) {
        loggerController.log(new StringCommand(message));
    }

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteCommand(message));
    }

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

    private static String convertArrayToString(int[] array) {
        String temp = "{";
        for (int i = 0; i < array.length - 1; i++) {
            temp += array[i] + DELIMETER;
        }
        temp += array[array.length - 1] + "}";
        return temp;

    }

    private static String convertMatrixToString(int[][] matrix) {
        String temp = "{\n";
        for (int[] array : matrix) {
            temp += convertArrayToString(array) + "\n";
        }
        temp += "}";
        return temp;
    }

    private static void flushBufferAndChangeTypeIfNeeded(Type type) {
        if (type == currentType) return;

        flush();
        currentType = type;
    }

    public static void flush() {
        switch (currentType) {
            case UNDEFINED:
                break;
            case INTEGER:
            case BYTE:
                flushByteState();
                break;
            case BOOLEAN:
                break;
            case CHAR:
                break;
            case STRING:
                flushStringType();
                break;
            case OBJECT:
                break;
            case ARRAY:
                break;
            case MATRIX:
                break;
        }
    }


    private static void accumulate(byte number) {
        accumulateNumberConcerningMaxValue(number, Byte.MAX_VALUE);
    }

    // endregion

}
