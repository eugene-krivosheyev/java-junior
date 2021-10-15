package com.acme.edu;


public class Logger {

    private static final String primitivePrefix = "primitive: ";
    private static final String charPrefix = "char: ";
    private static final String stringPrefix = "string: ";
    private static final String referencePrefix = "reference: ";


    private static final String stringType = "string";
    private static final String intType = "int";
    private static final String byteType = "byte";

    private static String bufferType = "";

    private static int intBuffer;

    private static String stringBuffer = "";
    private static int stringCount;

    public static void log(int message) {
        checkPreviousType(intType);
        checkIntOverflow(Integer.MAX_VALUE, message);
    }

    public static void log(byte message) {
        checkPreviousType(byteType);
        checkIntOverflow(Byte.MAX_VALUE, message);
    }

    public static void log(char message) {
        print(charPrefix + message);
    }

    public static void log(String message) {
        checkPreviousType(stringType);

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
        print(primitivePrefix + message);
    }

    public static void log(Object message) {
        print(referencePrefix + message);
    }

    public static void flush() {
        switch (bufferType) {
            case stringType:
                if (stringCount > 1) {
                    print(stringPrefix + stringBuffer + " (x" + stringCount + ")");
                } else {
                    print(stringPrefix + stringBuffer);
                }

                stringBuffer = "";
                stringCount = 0;
                break;
            case intType:
            case byteType:
                print(primitivePrefix + intBuffer);
                intBuffer = 0;
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

    private static void checkIntOverflow(int limit, int num) {
        int remainder = limit - intBuffer;
        if (num >= remainder) {
            intBuffer = limit;
            flush();
            intBuffer = num - remainder;
        } else {
            intBuffer += num;
        }
    }
}
