package com.acme.edu;


public class Logger {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";
    private final static String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";
    private final static String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";
    private final static String PRIMITIVES_MULTIMATRIX_PREFIX = "primitives multimatrix: ";
    public static final String DELIMETER = ", ";

    private static enum Type {
        UNDEFINED,
        INTEGER,
        BYTE,
        BOOLEAN,
        CHAR,
        STRING,
        OBJECT,
        ARRAY,
        MATRIX
    }

    private static Type currentType = Type.UNDEFINED;

    private static String stringBuffer = null;
    private static int stringCounter = 0;

    private static long numberBuffer = 0;
    private static boolean isNumberBufferNotEmpty = false;

    public static void log(String message) {
        flashAndChangeTypeIfNeeded(Type.STRING);
        accumulate(message);
    }

    public static void log(int message) {
        flashAndChangeTypeIfNeeded(Type.INTEGER);
        accumulate(message);
    }

    public static void log(byte message) {
        flashAndChangeTypeIfNeeded(Type.BYTE);
        accumulate(message);
    }

    public static void log(boolean message) {
        flashAndChangeTypeIfNeeded(Type.BOOLEAN);
        decorateAndPrintPrimitive(String.valueOf(message));
    }

    public static void log(char message) {
        flashAndChangeTypeIfNeeded(Type.CHAR);
        decorateAndPrintChar(String.valueOf(message));
    }

    public static void log(Object message) {
        flashAndChangeTypeIfNeeded(Type.OBJECT);
        decorateAndPrintObject(String.valueOf(message));
    }

    public static void log(int[] array) {
        flashAndChangeTypeIfNeeded(Type.ARRAY);
        decorateAndPrintArray(convertArrayToString(array));
    }

    public static void log(int[][] matrix) {
        flashAndChangeTypeIfNeeded(Type.MATRIX);
        decorateAndPrintMatrix(convertMatrixToString(matrix));
    }

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

    private static void flashAndChangeTypeIfNeeded(Type type) {
        final boolean shouldTypeBeChanged = (type != currentType);
        if (shouldTypeBeChanged) {
            flush();
            currentType = type;
        }
    }

    public static void flush() {
        switch (currentType) {
            case UNDEFINED:
                break;
            case INTEGER:
            case BYTE:
                if (isNumberBufferNotEmpty) {
                    decorateAndPrintPrimitive(String.valueOf(numberBuffer));
                }
                numberBuffer = 0;
                isNumberBufferNotEmpty = false;
                break;
            case BOOLEAN:
                break;
            case CHAR:
                break;
            case STRING:
                if (stringBuffer == null) break;
                String message = stringBuffer;
                if (stringCounter > 1) {
                    message += " (x" + stringCounter + ")";
                }
                decorateAndPrintString(message);
                stringBuffer = null;
                break;
            case OBJECT:
                break;
            case ARRAY:
                break;
            case MATRIX:
                break;
        }
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
        return PRIMITIVE_PREFIX + message;
    }

    private static String decorateString(String message) {
        return STRING_PREFIX + message;
    }

    private static String decorateReference(String message) {
        return REFERENCE_PREFIX + message;
    }

    private static String decorateChar(String message) {
        return CHAR_PREFIX + message;
    }

    private static String decorateArray(String message) {
        return PRIMITIVES_ARRAY_PREFIX + message;
    }

    private static String decorateMatrix(String message) {
        return PRIMITIVES_MATRIX_PREFIX + message;
    }
    // endregion

    // region Loggers for each type
    private static void decorateAndPrintPrimitive(String message) {
        Printer.print(decoratePrimitive(message));
    }

    private static void decorateAndPrintChar(String message) {
        Printer.print(decorateChar(message));
    }

    private static void decorateAndPrintString(String message) {
        Printer.print(decorateString(message));
    }

    private static void decorateAndPrintObject(String message) {
        Printer.print(decorateReference(message));
    }

    private static void decorateAndPrintArray(String message) {
        Printer.print(decorateArray(message));
    }

    private static void decorateAndPrintMatrix(String message) {
        Printer.print(decorateMatrix(message));
    }
    // endregion
}
