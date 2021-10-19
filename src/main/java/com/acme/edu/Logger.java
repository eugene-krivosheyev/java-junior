package com.acme.edu;


public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    enum Type {
        STRING,
        INT,
        BYTE,
        INT_ARRAY,
        INT_MATRIX,
        NONE
    }

    private static Type bufferType = Type.NONE;
    private static long numBuffer;

    private static String stringBuffer = null;
    private static int stringCount;

    public static void log(int... message) {
        checkPreviousType(Type.INT_ARRAY);
        for (int num : message) {
            addNumber(Integer.MAX_VALUE, Integer.MIN_VALUE, num);
        }
    }

    public static void log(int[][] message) {
        checkPreviousType(Type.INT_MATRIX);
        for (int[] subarray : message) {
            for (int num : subarray) {
                addNumber(Integer.MAX_VALUE, Integer.MIN_VALUE, num);
            }
        }
    }

    public static void log(String... message) {
        for (String str : message) {
            log(str);
        }
    }

    public static void log(int message) {
        checkPreviousType(Type.INT);
        addNumber(Integer.MAX_VALUE, Integer.MIN_VALUE, message);
    }

    public static void log(byte message) {
        checkPreviousType(Type.BYTE);
        addNumber(Byte.MAX_VALUE, Byte.MIN_VALUE, message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (message == null) throw new NullPointerException("String message can not be null");

        checkPreviousType(Type.STRING);
        if (stringBuffer == null) {
            stringBuffer = message;
            stringCount++;
            return;
        }
        if (!message.equals(stringBuffer)) {
            flush();
            stringBuffer = message;
        }
        stringCount++;
    }

    public static void log(boolean message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        print(REFERENCE_PREFIX + message);
    }

    public static void flush() {
        switch (bufferType) {
            case STRING:
                if (stringCount > 1) {
                    print(STRING_PREFIX + stringBuffer + " (x" + stringCount + ")");
                } else {
                    print(STRING_PREFIX + stringBuffer);
                }

                stringBuffer = "";
                stringCount = 0;
                break;
            case INT:
            case BYTE:
            case INT_ARRAY:
            case INT_MATRIX:
                print(PRIMITIVE_PREFIX + numBuffer);
                numBuffer = 0;
                break;
        }
    }

    private static void checkPreviousType(Type currentType) {
        if (bufferType == Type.NONE) {
            bufferType = currentType;
            return;
        }
        if (!currentType.equals(bufferType)) {
            flush();
            bufferType = currentType;
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void addNumber(long maxLimit, long minLimit, long num) {
        long sum = num + numBuffer;
        if (sum <= minLimit) {
            numBuffer = minLimit;
            flush();
            numBuffer = sum - minLimit;
        } else if (sum >= maxLimit) {
            numBuffer = maxLimit;
            flush();
            numBuffer = sum - maxLimit;
        } else {
            numBuffer += num;
        }
    }
}
