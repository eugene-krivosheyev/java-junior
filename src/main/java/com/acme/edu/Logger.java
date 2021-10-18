package com.acme.edu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private static final String PRIMITIVE_ARRAY_MATRIX = "primitives matrix: ";
    private static String currentMessage;
    private static long currentIntSum = 0;
    private static int currentByteSum = 0;

    private static String lastSubmittedString;
    private static int sameLastStringCounter = 1;

    private static boolean isLastInt = false;
    private static boolean isLastByte = false;
    private static boolean isLastString = false;

    private static boolean arrayToggle = false;

    public static void log(int message) {
        if (!isLastInt) {
            flush();
            setLastInt();
        }
        currentIntSum = handleOverflow(currentIntSum, Integer.MAX_VALUE, Integer.MIN_VALUE, message);
    }

    public static void log(byte message) {
        if (!isLastByte) {
            flush();
            setLastByte();
        }
        currentByteSum = (int) handleOverflow(currentByteSum, Byte.MAX_VALUE, Byte.MIN_VALUE, message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (isLastString && lastSubmittedString.equals(message)) {
            sameLastStringCounter += 1;
        } else {
            flush();
            setLastSubmittedString(message);
        }
    }

    public static void log(String... strings) {
        Arrays.stream(strings).forEach(Logger::log);
    }

    public static void setArrayToggle() {
        arrayToggle = true;
    }

    public static void log(int... integers) {
        if (!arrayToggle) {
            accumTheSum(integers);
        } else {
            print(PRIMITIVE_ARRAY_PREFIX + makeTheString(integers));
            arrayToggle = false;
        }
    }

    public static void log(int[][] integers) {
        if (!arrayToggle) {
            for (int[] row : integers) {
                accumTheSum(row);
            }
        } else {
            print(PRIMITIVE_ARRAY_MATRIX + make2DString(integers));
            arrayToggle = false;
        }
    }

    public static void log(boolean message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        print(REFERENCE_PREFIX + message);
    }

    public static void flush() {
        if (handleCurrentMessage()) {
            print(currentMessage);
        }
    }

    private static void accumTheSum(int[] array) {
        for (int j : array) {
            log(j);
        }
    }

    private static String makeTheString(int[] array) {
        StringBuilder arrayToString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayToString.append("{");
            }
            arrayToString.append(array[i]);
            if (i != array.length - 1) {
                arrayToString.append(", ");
            } else {
                arrayToString.append("}");
            }
        }
        return (arrayToString.toString());
    }

    private static String make2DString(int[][] array) {
        StringBuilder arrayTo2DString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arrayTo2DString.append("{\n");
            }
            arrayTo2DString.append(makeTheString(array[i]) + "\n");
            if (i == array.length - 1) {
                arrayTo2DString.append("}");
            }
        }
        return arrayTo2DString.toString();
    }

    private static boolean handleCurrentMessage() {
        if (isLastInt) {
            currentMessage = PRIMITIVE_PREFIX + currentIntSum;
            currentIntSum = 0;
            isLastInt = false;
            return true;
        } else if (isLastByte) {
            currentMessage = PRIMITIVE_PREFIX + currentByteSum;
            currentByteSum = 0;
            isLastByte = false;
            return true;
        } else if (isLastString) {
            handleRepeatingStrings();
            isLastString = false;
            sameLastStringCounter = 1;
            return true;
        }
        return false;
    }

    private static void handleRepeatingStrings() {
        if (sameLastStringCounter == 1) {
            currentMessage = STRING_PREFIX + lastSubmittedString;
        } else {
            currentMessage = STRING_PREFIX + lastSubmittedString + " (x" + sameLastStringCounter + ")";
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void setLastInt() {
        setStateFalse();
        isLastInt = true;
    }

    private static void setLastByte() {
        setStateFalse();
        isLastByte = true;
    }

    private static void setStateFalse() {
        isLastInt = false;
        isLastByte = false;
        isLastString = false;
    }

    private static void setLastSubmittedString(String message) {
        setStateFalse();
        lastSubmittedString = message;
        isLastString = true;
    }

    private static long handleOverflow(long current, long positive, long negative, long addition) {
        current += addition;
        if (current > positive) {
            print(String.valueOf(positive));
            return current - positive;
        } else if (current < negative) {
            print(String.valueOf(positive));
            return current - negative;
        }
        return current;
    }
}
