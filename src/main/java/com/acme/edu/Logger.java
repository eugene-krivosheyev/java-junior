package com.acme.edu;

public class Logger {
    enum MessageType {
        BOOLEAN, BYTE, INT, CHAR, STRING, OBJECT
    }

    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    private static MessageType previousType = null;
    private static int intSum = 0;
    private static byte byteSum = 0;
    private static String prevString = null;
    private static int countPrevString = 0;

    private static boolean isOverflow(int val1, int val2) {
        return val1 > 0 ?
                Integer.MAX_VALUE - val1 < val2 :
                Integer.MIN_VALUE - val1 > val2;
    }

    private static boolean isOverflow(byte val1, byte val2) {
        return val1 > 0 ?
                Byte.MAX_VALUE - val1 < val2 :
                Byte.MIN_VALUE - val1 > val2;
    }

    private static void flushWithoutStateChange() {
        switch (previousType) {
            case BOOLEAN:
                break;
            case BYTE:
                save(PRIMITIVE + byteSum);
                byteSum = 0;
                break;
            case INT:
                save(PRIMITIVE + intSum);
                intSum = 0;
                break;
            case CHAR:
                break;
            case STRING:
                save(STRING + prevString + (countPrevString > 1 ? " (x" + countPrevString + ")" : ""));
                prevString = null;
                countPrevString = 0;
                break;
            case OBJECT:
                break;
        }
    }

    public static void flush() {
        flushWithoutStateChange();
        previousType = null;
    }

    private static void updateState(MessageType currentType) {
        if (previousType != currentType) {
            if (previousType != null) {
                flush();
            }
            previousType = currentType;
        }
    }

    public static void log(int message) {
        updateState(MessageType.INT);
        if(isOverflow(intSum, message)) {
            flushWithoutStateChange();
        }
        intSum += message;
    }

    public static void log(byte message) {
        updateState(MessageType.BYTE);
        if(isOverflow(byteSum ,message)) {
            flushWithoutStateChange();
        }
        byteSum += message;
    }

    public static void log(char message) {
        updateState(MessageType.CHAR);
        save(CHAR + message);
    }

    public static void log(String message) {
        updateState(MessageType.STRING);
        if (prevString != null && prevString.equals(message)) {
            countPrevString += 1;
        } else {
            if(prevString != null)
                flushWithoutStateChange();
            prevString = message;
            countPrevString = 1;
        }
    }

    public static void log(boolean message) {
        updateState(MessageType.BOOLEAN);
        save(PRIMITIVE + message);
    }

    public static void log(Object message) {
        updateState(MessageType.OBJECT);
        save(REFERENCE + message);
    }

    private static void save(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
