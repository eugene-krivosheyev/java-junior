package com.db.education.app;
    
import java.util.Objects;

public class Logger {
    public static final String CHAR_PREFIX = "char: ";
    public static final String OBJECT_PREFIX = "reference: ";
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String STRING_PREFIX = "string: ";

    private static int accumulatedByte = 0;
    private static long accumulatedInteger = 0;
    private static int countOfString = 0;
    private static String lastString = "";
    private static Object lastMessage;

    private Logger() {
    }

    public static void log(int message) {
        updateLastMessageType(message);
        accumulateInteger(message);
    }

    public static void log(byte message) {
        updateLastMessageType(message);
        accumulateByte(message);
    }

    public static void log(char message) {
        updateLastMessageType(message);
        writeToOutput(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        updateLastMessageType(message);
        accumulateString(message);
    }

    public static void log(boolean message) {
        updateLastMessageType(message);
        writeToOutput(PRIMITIVE_PREFIX, message);
    }

    public static void log(Object message) {
        updateLastMessageType(message);
        writeToOutput(OBJECT_PREFIX, message);
    }

    public static void flush() {
        if (lastMessage instanceof Integer) {
            flushInteger();
        } else if (lastMessage instanceof Byte) {
            flushByte();
        } else if (lastMessage instanceof String) {
            flushString();
        }
    }

    private static void accumulateString(String message) {
        if (Objects.equals(lastString, message)) {
            ++countOfString;
        } else {
            if (!lastString.isEmpty()) {
                writeStringToOutput();
            }
            lastString = message;
            countOfString = 1;
        }
    }

    private static long accumulateNumber(long accumulatedValue, long number, long minValue, long maxValue)
    {
        accumulatedValue += number;
        if(accumulatedValue > maxValue) {
            writeToOutput(PRIMITIVE_PREFIX, maxValue);
            accumulatedValue -= maxValue;
        } else if(accumulatedInteger < minValue) {
            writeToOutput(PRIMITIVE_PREFIX, minValue);
            accumulatedValue -= minValue;
        }
        return accumulatedValue;
    }

    private static void accumulateInteger(int number) {
        accumulatedInteger =
                accumulateNumber(accumulatedInteger, number, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static void accumulateByte(byte number) {
        accumulatedByte =
                (byte)accumulateNumber(accumulatedByte, number, Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    private static void updateLastMessageType(Object message) {
        if (lastMessage != null &&
                !Objects.equals(lastMessage.getClass().getName(), message.getClass().getName())) {
            flush();
        }
        lastMessage = message;
    }

    private static void flushInteger() {
        writeToOutput(PRIMITIVE_PREFIX, accumulatedInteger);
        accumulatedInteger = 0;
    }

    private static void flushByte() {
        writeToOutput(PRIMITIVE_PREFIX, accumulatedByte);
        accumulatedByte = 0;
    }

    private static void flushString() {
        writeStringToOutput();
        countOfString = 0;
        lastString = "";
    }

    private static void writeToOutput(String prefix, Object message) {
        System.out.print(prefix + message + System.lineSeparator());
    }

    private static void writeStringToOutput() {
        String countString = "";
        if (countOfString > 1) {
            countString = " (x" + countOfString + ")";
        }
        writeToOutput(STRING_PREFIX, lastString + countString);
    }
}
