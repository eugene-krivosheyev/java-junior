package com.acme.edu;

public class OldLogger {

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

    public static void log(int message) {
        checkOverFlow(message, LastLoggedType.INT);

        if (!lastLoggedType.equals(LastLoggedType.INT)) {
            processAllBuffers();
        }

        lastLoggedType = LastLoggedType.INT;
    }

    public static void log(int... integers) {
        processArray(integers);
    }

    public static void log(byte message) {
        checkOverFlow(message, LastLoggedType.BYTE);

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

    public static void log(String... strings) {
        processArray(strings);
    }

    public static void log(Object message) {
        processAllBuffers();
        save(formatMessage(OBJECT_PREFIX, message));
        lastLoggedType = LastLoggedType.OBJ;
    }

    private static int getOverflowValue(LastLoggedType type) {
        switch ( type ) {
            case INT: {
                return integerThresholdValueCounter > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            case BYTE: {
                return byteThresholdValueCounter > 0 ? Byte.MAX_VALUE : Byte.MIN_VALUE;
            }
            default: {
                return 0;
            }
        }
    }

    private static int getThresholdValueCounter(LastLoggedType type) {
        switch (type) {
            case INT: {
                return integerThresholdValueCounter;
            }
            case BYTE: {
                return byteThresholdValueCounter;
            }
            default:{
                return 0;
            }
        }
    }

    private static int getThresholdValue(int message, LastLoggedType type) {
        switch (type) {
            case INT: {
                if ( message > 0 ) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            case BYTE: {
                if ( message > 0 ) {
                    return Byte.MAX_VALUE;
                } else {
                    return Byte.MIN_VALUE;
                }
            }
            default: {
                return 0;
            }
        }
    }

    private static boolean isMessageEqualThresholdValue(int message, LastLoggedType type, int thresholdValue) {
        if (message == thresholdValue) {
            if ( thresholdValue > 0 ) {
                changeThresholdValueCounter(ChangeType.INCREASE, type);
            } else {
                changeThresholdValueCounter(ChangeType.DECREASE, type);
            }
            return true;
        } else {
            return false;
        }
    }

    private static int getBuffer(LastLoggedType type) {
        switch (type) {
            case INT: {
                return intBuffer;
            }
            case BYTE: {
                return byteBuffer;
            }
            default: {
                return 0;
            }
        }
    }

    private static void checkOverFlow(int message, LastLoggedType type) {
        int thresholdValue = getThresholdValue(message, type);
        if ( isMessageEqualThresholdValue(message, type, thresholdValue) ) return;

        int buffer = getBuffer(type);

        long diff = Math.abs(thresholdValue - (long) buffer);
        if (diff > Math.abs((long) message)) {
            appendBuffer(type, message);
        } else {
            if ( thresholdValue > 0 ) {
                assignBuffer(type, (message - diff) );
                changeThresholdValueCounter(ChangeType.INCREASE, type);
            } else {
                assignBuffer(type, (message + diff));
                changeThresholdValueCounter(ChangeType.DECREASE, type);
            }
        }
    }

    private static void assignBuffer( LastLoggedType type, long value ) {
        switch (type) {
            case INT: {
                intBuffer = (int) value;
                break;
            }
            case BYTE: {
                byteBuffer = (byte) value;
                break;
            }
        }
    }

    private static void appendBuffer( LastLoggedType type, long value ) {
        switch (type) {
            case INT: {
                intBuffer += value;
                break;
            }
            case BYTE: {
                byteBuffer += value;
                break;
            }
        }
    }

    private enum ChangeType {
        INCREASE,
        DECREASE
    }

    private static void decreaseBuffer(LastLoggedType type) {
        int[] res;
        switch (type) {
            case INT: {
                res = decreaseBuffer(Integer.MIN_VALUE, intBuffer, integerThresholdValueCounter);
                intBuffer = res[0];
                integerThresholdValueCounter = res[1];
                break;
            }
            case BYTE: {
                res = decreaseBuffer(Byte.MIN_VALUE, byteBuffer, byteThresholdValueCounter);
                byteBuffer = res[0];
                byteThresholdValueCounter = res[1];
                break;
            }
        }
    }

    private static int[] decreaseBuffer(int thresholdValue, int buffer, int counter) {
        --buffer;
        if (buffer == thresholdValue) {
            buffer = 0;
            --counter;
        }

        return new int[] {buffer, counter};
    }

    private static void changeCounter(ChangeType changeType, LastLoggedType type) {
        switch (type) {
            case INT: {
                switch (changeType) {
                    case INCREASE: {
                        ++integerThresholdValueCounter;
                        break;
                    }
                    case DECREASE: {
                        --integerThresholdValueCounter;
                        break;
                    }
                }
                break;
            }
            case BYTE: {
                switch (changeType) {
                    case INCREASE: {
                        ++byteThresholdValueCounter;
                        break;
                    }
                    case DECREASE: {
                        --byteThresholdValueCounter;
                        break;
                    }
                }
                break;
            }
        }
    }

    private static void changeThresholdValueCounter(ChangeType changeType, LastLoggedType type) {
        int thresholdValueCounter = getThresholdValueCounter(type);

        switch (changeType) {
            case INCREASE: {
                if (thresholdValueCounter < 0) {
                    decreaseBuffer(type);
                }

                break;
            }
            case DECREASE: {
                if (thresholdValueCounter > 0) {
                    decreaseBuffer(type);
                }
                break;
            }
        }

        changeCounter(changeType, type);
    }

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

            cleanBuffer(LastLoggedType.STRING);
        }
    }

    private static void processNumericBuffer(LastLoggedType type, String prefix) {
        int overflowValue = getOverflowValue(type);
        int counter = getThresholdValueCounter(type);
        int buffer = getBuffer(type);

        for (int i = 0; i < Math.abs(counter); i++) {
            save(formatMessage(prefix, overflowValue));
        }
        if (counter == 0 || buffer != 0) {
            save(formatMessage(prefix, buffer));
        }
        cleanBuffer(type);
    }

    private static void cleanStringBuffer() {
        repeatableStringCounter = 0;
    }

    private static void cleanIntBuffer() {
        intBuffer = 0;
        integerThresholdValueCounter = 0;
    }

    private static void cleanByteBuffer() {
        byteBuffer = 0;
        byteThresholdValueCounter = 0;
    }

    private static void cleanBuffer(LastLoggedType type) {
        switch (type) {
            case INT: {
                cleanIntBuffer();
                break;
            }
            case BYTE: {
                cleanByteBuffer();
                break;
            }
            case STRING: {
                cleanStringBuffer();
                break;
            }
        }
    }

    private static void processArray(int... integers){
        for (int integer: integers) {
            log(integer);
        }
    }

    private static void processArray(String... strings){
        for (String string: strings) {
            log(string);
        }
    }

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
            case BYTE:
            case INT: {
                    processNumericBuffer(lastLoggedType, PRIMITIVE_PREFIX);
                    break;
            }
            case STRING: {
                processStringBuffer();
                break;
            }
        }
    }
}

