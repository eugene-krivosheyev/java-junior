package com.acme.edu;

public class Logger {
    private static final String primitivePrefix = "primitive: ";
    private static final String charPrefix = "char: ";
    private static final String stringPrefix = "string: ";
    private static final String referencePrefix = "reference: ";
    private static String currentMessage;
    private static long currentIntSum = 0;
    private static int currentByteSum = 0;

    private static String lastSubmittedString;
    private static int sameLastStringCounter = 1;

    private static boolean isLastInt = false;
    private static boolean isLastByte = false;
    private static boolean isLastString = false;

    public static void log(int message) {
        if (!isLastInt) {
            flush();
            setLastInt();
        }
        currentIntSum += message;
        currentIntSum = handleOverflow(currentIntSum, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void log(byte message) {
        if (!isLastByte) {
            flush();
            setLastByte();
        }
        currentByteSum += message;
        currentByteSum = (int) handleOverflow(currentByteSum, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    public static void log(char message) {
        print(charPrefix + message);
    }

    public static void log(String message) {
        if (isLastString && lastSubmittedString.equals(message)) {
            sameLastStringCounter += 1;
        } else {
            flush();
            setLastSubmittedString(message);
        }
    }

    public static void log(boolean message) {
        print(primitivePrefix + message);
    }

    public static void log(Object message) {
        print(referencePrefix + message);
    }

    public static void flush() {
        if (handleCurrentMessage()) {
            print(currentMessage);
        }
    }

    private static boolean handleCurrentMessage() {
        if (isLastInt) {
            currentMessage = primitivePrefix + currentIntSum;
            currentIntSum = 0;
            isLastInt = false;
            return true;
        } else if (isLastByte) {
            currentMessage = primitivePrefix + currentByteSum;
            currentByteSum = 0;
            isLastByte = false;
            return true;
        } else if (isLastString) {
            if (sameLastStringCounter == 1) {
               currentMessage = stringPrefix + lastSubmittedString;
            } else {
                currentMessage = stringPrefix + lastSubmittedString + " (x" + sameLastStringCounter + ")";
            }
            isLastString = false;
            sameLastStringCounter = 1;
            return true;
        }
        return false;
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

    private static long handleOverflow(long current, long positive, long negative) {
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
