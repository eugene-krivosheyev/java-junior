package com.acme.edu;

public class Logger {

    private enum LastLoggedType {
        NONE,
        OBJ,
        BYTE,
        INT,
        CHAR,
        BOOL,
        STRING
    }

    private static LastLoggedType lastLoggedType = LastLoggedType.NONE;

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    private static int intBuffer;
    private static int integerThresholdValueCounter;

    private static int byteBuffer;
    private static int byteThresholdValueCounter;

    private static int repeatableStringCounter;
    private static String lastString;

    //region loggers
    public static void log(int message) {
        checkIntOverFlow(message);

        if (!lastLoggedType.equals(LastLoggedType.INT)) {
            processAllBuffers();
        }

        lastLoggedType = LastLoggedType.INT;
    }

    public static void log(byte message) {
        checkByteOverFlow(message);

        if (!lastLoggedType.equals(LastLoggedType.BYTE)) {
            processAllBuffers();
        }

        lastLoggedType = LastLoggedType.BYTE;
    }

    public static void log(char message) {
        processAllBuffers();
        save(formatMessage(CHAR_PREFIX, message));
        lastLoggedType = LastLoggedType.CHAR;
    }

    public static void log(boolean message) {
        processAllBuffers();
        save(formatMessage(PRIMITIVE_PREFIX, message));
        lastLoggedType = LastLoggedType.BOOL;
    }

    public static void log(String message) {
        if (!lastLoggedType.equals(LastLoggedType.STRING) || !message.equals(lastString)) {
            processAllBuffers();
        }

        lastString = message;
        ++repeatableStringCounter;

        lastLoggedType = LastLoggedType.STRING;
    }

    public static void log(Object message) {
        processAllBuffers();
        save(formatMessage(OBJECT_PREFIX, message));
        lastLoggedType = LastLoggedType.OBJ;
    }
    //endregion

    //region int methods
    private static void checkIntOverFlow(int message) {
        if (message == Integer.MAX_VALUE) {
            increaseIntegerThresholdValueCounter();
            return;
        }

        if (message == Integer.MIN_VALUE) {
            decreaseIntegerThresholdValueCounter();
            return;
        }

        if (message > 0) {
            checkMaxIntOverFlow(message);
        } else {
            checkMinIntOverFlow(message);
        }
    }

    private static void checkMaxIntOverFlow(int message) {
        long diff = Integer.MAX_VALUE - (long) intBuffer;
        if (diff > message) {
            intBuffer += message;
        } else {
            intBuffer = (int) (message - diff);
            increaseIntegerThresholdValueCounter();
        }
    }

    private static void checkMinIntOverFlow(int message) {
        long diff = (long) intBuffer - Integer.MIN_VALUE;
        if (diff > Math.abs((long) message)) {
            intBuffer += message;
        } else {
            intBuffer = (int) (message + diff);
            decreaseIntegerThresholdValueCounter();
        }
    }

    private static void increaseIntegerThresholdValueCounter() {
        if (integerThresholdValueCounter < 0) {
            --intBuffer;
        }
        ++integerThresholdValueCounter;
    }

    private static void decreaseIntegerThresholdValueCounter() {
        if (integerThresholdValueCounter > 0) {
            --intBuffer;
            if (intBuffer == Integer.MIN_VALUE) {
                intBuffer = 0;
                --integerThresholdValueCounter;
            }
        }
        --integerThresholdValueCounter;
    }

    private static void processIntBuffer() {
        int overflowValue = integerThresholdValueCounter > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i = 0; i < Math.abs(integerThresholdValueCounter); i++) {
            save(formatMessage(PRIMITIVE_PREFIX, overflowValue));
        }
        if (integerThresholdValueCounter == 0 || intBuffer != 0) {
            save(formatMessage(PRIMITIVE_PREFIX, intBuffer));
        }
        cleanIntBuffer();
    }

    private static void cleanIntBuffer() {
        intBuffer = 0;
        integerThresholdValueCounter = 0;
    }

    //endregion

    //region byte methods
    private static void checkByteOverFlow(byte message) {
        if (message == Byte.MAX_VALUE) {
            increaseByteThresholdValueCounter();
            return;
        }

        if (message == Byte.MIN_VALUE) {
            decreaseByteThresholdValueCounter();
            return;
        }

        if (message > 0) {
            checkMaxByteOverFlow(message);
        } else {
            checkMinByteOverFlow(message);
        }
    }

    private static void checkMaxByteOverFlow(byte message) {
        long diff = Byte.MAX_VALUE - (long) byteBuffer;
        if (diff > message) {
            byteBuffer += message;
        } else {
            byteBuffer = (byte) (message - diff);
            increaseByteThresholdValueCounter();
        }
    }

    private static void checkMinByteOverFlow(byte message) {
        long diff = (long) byteBuffer - Byte.MIN_VALUE;
        if (diff > Math.abs((long) message)) {
            byteBuffer += message;
        } else {
            byteBuffer = (byte) (message + diff);
            decreaseByteThresholdValueCounter();
        }
    }

    private static void increaseByteThresholdValueCounter() {
        if (byteThresholdValueCounter < 0) {
            --byteBuffer;
        }
        ++byteThresholdValueCounter;
    }

    private static void decreaseByteThresholdValueCounter() {
        if (byteThresholdValueCounter > 0) {
            --byteBuffer;
            if (byteBuffer == Byte.MIN_VALUE) {
                byteBuffer = 0;
                --byteThresholdValueCounter;
            }
        }
        --byteThresholdValueCounter;
    }

    private static void processByteBuffer() {
        byte overflowValue = byteThresholdValueCounter > 0 ? Byte.MAX_VALUE : Byte.MIN_VALUE;
        for (byte i = 0; i < Math.abs(byteThresholdValueCounter); i++) {
            save(formatMessage(PRIMITIVE_PREFIX, overflowValue));
        }
        if (byteThresholdValueCounter == 0 || byteBuffer != 0) {
            save(formatMessage(PRIMITIVE_PREFIX, byteBuffer));
        }
        cleanByteBuffer();
    }

    private static void cleanByteBuffer() {
        byteBuffer = 0;
        byteThresholdValueCounter = 0;
    }
    //endregion

    //region string methods
    private static boolean checkStringBuffer() {
        return repeatableStringCounter > 0;
    }

    private static void processStringBuffer() {
        if (checkStringBuffer()) {
            if (repeatableStringCounter > 1) {
                save(formatMessage(STRING_PREFIX, lastString + " (x" + repeatableStringCounter + ")"));
            } else {
                save(formatMessage(STRING_PREFIX, lastString));
            }

            cleanStringBuffer();
        }
    }

    private static void cleanStringBuffer() {
        repeatableStringCounter = 0;
    }
    //endregion

    private static String formatMessage(String prefix, Object message) {
        return prefix + message;
    }

    private static void save(String message) {
        System.out.println(message);
    }

    public static void flush() {
        processAllBuffers();
    }

    public static void processAllBuffers() {
        switch (lastLoggedType) {
            case BYTE: {
                processByteBuffer();
                break;
            }
            case INT: {
                processIntBuffer();
                break;
            }
            case STRING: {
                processStringBuffer();
                break;
            }
        }
    }
}

