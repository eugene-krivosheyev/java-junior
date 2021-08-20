package com.acme.edu;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    private static int intBuffer;
    private static int intMaxMinValueCounter;
    private static boolean lastLogIntegerFlag;

    public static void log(int message) {
        //save(formatMessage(PRIMITIVE_PREFIX, message));
        checkIntOverFlow(message);
        lastLogIntegerFlag = true;
    }

    private static  void checkIntOverFlow(int message) {
        if (message > 0) {
            checkMaxIntOverFlow(message);
        } else {
            checkMinIntOverFlow(message);
        }
    }

    private static void checkMaxIntOverFlow(int message /*>=0*/) {
        long diff = Integer.MAX_VALUE-(long)intBuffer;
        if ( diff > message) {
            intBuffer += message;
        } else { // only if intBuffer > 0
            intBuffer = (int)(message-diff);
            if (intMaxMinValueCounter > 0) {
                --intBuffer;
            }
            ++intMaxMinValueCounter;
        }
    }

    private static void checkMinIntOverFlow(int message) {
        long diff = (long)intBuffer-Integer.MIN_VALUE;
        if ( diff > Math.abs(message)) {
            intBuffer += message;
        } else { // only if intBuffer < 0
            intBuffer = (int)(message+diff);
            if (intMaxMinValueCounter < 0) {
                --intBuffer;
            }
            --intMaxMinValueCounter;
        }
    }
    public static void log(byte message) {
        processIntBuffer();
        save(formatMessage(PRIMITIVE_PREFIX, message));
    }

    public static void log(char message) {
        processIntBuffer();
        save(formatMessage(CHAR_PREFIX, message));
    }
    public static void log(boolean message) {
        processIntBuffer();
        save(formatMessage(PRIMITIVE_PREFIX, message));
    }

    public static void log(String message) {
        processIntBuffer();
        save(formatMessage(STRING_PREFIX, message));
    }

    public static void log(Object message) {
        processIntBuffer();
        save(formatMessage(OBJECT_PREFIX, message));
    }

    private static String formatMessage(String prefix, Object message) {
        return prefix + message;
    }

    private static void save(String message) {
        print(message);
    }
    private static void print(String message) {
        System.out.println(message);
    }

    private static void processIntBuffer() {
        if (checkIntBuffer()){
            int overflowValue = intMaxMinValueCounter > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            for (int i=0; i < Math.abs(intMaxMinValueCounter); i++) {
              save(formatMessage(PRIMITIVE_PREFIX, overflowValue));
            }
            save(formatMessage(PRIMITIVE_PREFIX, intBuffer));
            cleanIntBuffer();
        }
    }

    private static void cleanIntBuffer() {
        intBuffer = 0;
        lastLogIntegerFlag = false;
    }

    private static boolean checkIntBuffer() {
        return lastLogIntegerFlag;
    }

    public static void flush() {
        processIntBuffer();
    }
}

