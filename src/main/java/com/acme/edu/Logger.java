package com.acme.edu;


public class Logger {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    public static final String DELIMETER = ", ";

    private static enum Type {
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

    private static String stringBuffer = null;
    private static int stringCounter = 0;

    private static long numberBuffer = 0;
    private static boolean isNumberBufferNotEmpty = false;

    // region Log methods
    public static void log(String message) {
        flushBufferAndChangeTypeIfNeeded(Type.STRING);
        accumulate(message);
    }

    public static void log(int message) {
        flushBufferAndChangeTypeIfNeeded(Type.INTEGER);
        accumulate(message);
    }

    public static void log(byte message) {
        flushBufferAndChangeTypeIfNeeded(Type.BYTE);
        accumulate(message);
    }

    public static void log(boolean message) {
        flushBufferAndChangeTypeIfNeeded(Type.BOOLEAN);
        decorateAndPrintPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        flushBufferAndChangeTypeIfNeeded(Type.CHAR);
        decorateAndPrintChar(String.valueOf(message));
    }

    public static void log(Object message) {
        flushBufferAndChangeTypeIfNeeded(Type.OBJECT);
        decorateAndPrintObject(String.valueOf(message));
    }

    public static void log(int[] array) {
        flushBufferAndChangeTypeIfNeeded(Type.ARRAY);
        decorateAndPrintArray(convertArrayToString(array));
    }

    public static void log(int[][] matrix) {
        flushBufferAndChangeTypeIfNeeded(Type.MATRIX);
        decorateAndPrintMatrix(convertMatrixToString(matrix));
    }

    public static void log(String... strings) {
        for(String str : strings) {
            flushBufferAndChangeTypeIfNeeded(Type.STRING);
            accumulate(str);
        }
    }
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

    private static void flushStringType() {
        if (stringBuffer == null) return;
        String message = stringBuffer;
        if (stringCounter > 1) {
            message += " (x" + stringCounter + ")";
        }
        decorateAndPrintString(message);
        stringBuffer = null;
    }

    private static void flushByteState() {
        if (isNumberBufferNotEmpty) {
            decorateAndPrintPrimitive(String.valueOf(numberBuffer));
        }
        numberBuffer = 0;
        isNumberBufferNotEmpty = false;
    }

    private static void initializeStringBuffer(String message) {
        stringBuffer = message;
        stringCounter = 1;
    }

    private static void accumulate(String message) {
        if (stringBuffer == null) {
            initializeStringBuffer(message);
        } else if (stringBuffer.equals(message)) {
            stringCounter++;
        } else {
            flush();
            initializeStringBuffer(message);
        }
    }

    private static void accumulate(int number) {
        accumulateNumberConcerningMaxValue(number, Integer.MAX_VALUE);
    }

    private static void accumulate(byte number) {
        accumulateNumberConcerningMaxValue(number, Byte.MAX_VALUE);
    }

    private static void accumulateNumberConcerningMaxValue(int number, int maxValue) {
        if (!isNumberBufferNotEmpty) {
            isNumberBufferNotEmpty = true;
        }
        if (numberBuffer + number >= maxValue) {
            flush();
            isNumberBufferNotEmpty = true;
        }
        numberBuffer += number;
    }

    // region Decorators
    private static String decoratePrimitive(String message) {
        return Type.INTEGER.getPrefix() + message;
    }

    private static String decorateString(String message) {
        return Type.STRING.getPrefix() + message;
    }

    private static String decorateReference(String message) {
        return Type.OBJECT.getPrefix() + message;
    }

    private static String decorateChar(String message) {
        return Type.CHAR.getPrefix() + message;
    }

    private static String decorateArray(String message) {
        return Type.ARRAY.getPrefix() + message;
    }

    private static String decorateMatrix(String message) {
        return Type.MATRIX.getPrefix() + message;
    }
    // endregion

    // region Print decorated messages
    private static void decorateAndPrintPrimitive(String message) {
        Saver.save(decoratePrimitive(message));
    }

    private static void decorateAndPrintChar(String message) {
        Saver.save(decorateChar(message));
    }

    private static void decorateAndPrintString(String message) {
        Saver.save(decorateString(message));
    }

    private static void decorateAndPrintObject(String message) {
        Saver.save(decorateReference(message));
    }

    private static void decorateAndPrintArray(String message) {
        Saver.save(decorateArray(message));
    }

    private static void decorateAndPrintMatrix(String message) {
        Saver.save(decorateMatrix(message));
    }
    // endregion
}
