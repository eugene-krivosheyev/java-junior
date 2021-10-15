package com.acme.edu;


public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";


    private static final String STRING_TYPE = "string";
    private static final String INT_TYPE = "int";
    private static final String BYTE_TYPE = "byte";

    private static String bufferType = "";

    private static long numBuffer;

    private static String stringBuffer = "";
    private static int stringCount;

    public static void log(int message) {
        checkPreviousType(INT_TYPE);
        checkOverflow(Integer.MAX_VALUE, Integer.MIN_VALUE, message);
    }

    public static void log(byte message) {
        checkPreviousType(BYTE_TYPE);
        checkOverflow(Byte.MAX_VALUE, Byte.MIN_VALUE, message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        checkPreviousType(STRING_TYPE);

        if (stringBuffer.isEmpty()) {
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
            case STRING_TYPE:
                if (stringCount > 1) {
                    print(STRING_PREFIX + stringBuffer + " (x" + stringCount + ")");
                } else {
                    print(STRING_PREFIX + stringBuffer);
                }

                stringBuffer = "";
                stringCount = 0;
                break;
            case INT_TYPE:
            case BYTE_TYPE:
                print(PRIMITIVE_PREFIX + numBuffer);
                numBuffer = 0;
                break;
        }
    }

    private static void checkPreviousType(String currentType) {
        if (bufferType.isEmpty()) {
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

    private static void checkOverflow(long maxLimit, long minLimit, long num) {
        long sum = num + numBuffer;
        if (sum <= minLimit) {
            numBuffer = minLimit;
            flush();
            numBuffer += sum - minLimit;
        } else if (sum >= maxLimit) {
            numBuffer = maxLimit;
            flush();
            numBuffer = sum - maxLimit;
        } else {
            numBuffer += num;
        }
    }
}
