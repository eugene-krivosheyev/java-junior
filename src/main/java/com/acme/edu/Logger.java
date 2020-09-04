package com.acme.edu;

public class Logger {
    final static String
            PREFIX_CHAR = "char: ",
            PREFIX_STRING = "string: ",
            PREFIX_REFERENCE = "reference: ",
            PREFIX_PRIMITIVE = "primitive: ";

    static int intBuffer = 0;
    static String strBuffer ="";
    static boolean intFlag = false;
    static boolean strFlag = false;
    static int counterSameStr = 0;
    static byte byteBuffer = 0;
    static boolean byteFlag = false;

    static void flushBuffer(boolean flushInt, boolean flushStr, boolean flushByte) {
        if (flushInt) {
            directToOutput(PREFIX_PRIMITIVE + intBuffer);
            intFlag = false;
            intBuffer = 0;
        }
        if (flushByte) {
            directToOutput(PREFIX_PRIMITIVE + byteBuffer);
            byteFlag = false;
            byteBuffer = 0;
        }
        if (flushStr) {
            if (counterSameStr > 1)
                directToOutput(PREFIX_STRING + strBuffer + " (x" + counterSameStr + ")");
            if (counterSameStr == 1)
                directToOutput(PREFIX_STRING + strBuffer);
            strFlag = false;
            strBuffer = "";
            counterSameStr = 0;
        }
    }

    public static void log(int message) {
        long sumCheck = (long) message + intBuffer;
        if (sumCheck >= Integer.MAX_VALUE) {
            flushBuffer(intFlag, strFlag, byteFlag);
            directToOutput(PREFIX_PRIMITIVE + message);
        } else {
            flushBuffer(false, strFlag, byteFlag);
            intFlag = true;
            intBuffer += message;
        }
    }

    public static void log(byte message) {
        int sumCheck = message + byteBuffer;
        if (sumCheck >= Byte.MAX_VALUE) {
            flushBuffer(intFlag, strFlag, byteFlag);
            directToOutput(PREFIX_PRIMITIVE + message);
        } else {
            flushBuffer(intFlag, strFlag, false);
            byteFlag = true;
            byteBuffer += message;
        }
    }

    public static void log(char message) {
        flushBuffer(intFlag, strFlag, byteFlag);
        directToOutput(PREFIX_CHAR + message);
    }

    public static void log(String message) {
        flushBuffer(intFlag, false, byteFlag);
        if (message.equals(strBuffer))
            counterSameStr ++;
        else {
            flushBuffer(intFlag, true, byteFlag);
            counterSameStr = 1;
            strFlag = true;
            strBuffer = message;
        }
    }

    public static void log(boolean message) {
        flushBuffer(intFlag, strFlag, byteFlag);
        directToOutput(PREFIX_PRIMITIVE + message);
    }

    public static void log(Object message) {
        flushBuffer(intFlag, strFlag, byteFlag);
        directToOutput(PREFIX_REFERENCE + message);
    }

    public static void flush() {
        flushBuffer(intFlag, strFlag, byteFlag);
    }

    static void directToOutput (String outputString){
        System.out.println(outputString);
    }

}
