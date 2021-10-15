package com.acme.edu;

public class Logger {
    private static final String primitivePrefix = "primitive: ";
    private static final String charPrefix = "char: ";
    private static final String stringPrefix = "string: ";
    private static final String referencePrefix = "reference: ";
    private static String currentMessage;
    private static long currentSum = 0;

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
        currentSum += message;
        handleIntOverflow();
    }

    public static void log(byte message) {
        if (!isLastByte) {
            flush();
            setLastByte();
        }
        currentSum += message;
        handleByteOverflow();
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
        if (isLastInt || isLastByte) {
            currentMessage = primitivePrefix + currentSum;
            currentSum = 0;
            isLastInt = false;
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
        isLastInt = true;
        isLastByte = false;
        isLastString = false;
    }

    private static void setLastByte() {
        isLastInt = false;
        isLastByte = true;
        isLastString = false;
    }

    private static void setLastSubmittedString(String message) {
        lastSubmittedString = message;
        isLastInt = false;
        isLastByte = false;
        isLastString = true;
    }

    private static void handleByteOverflow() {
        if (currentSum > Byte.MAX_VALUE) {
            print(String.valueOf(Byte.MAX_VALUE));
            currentSum = currentSum - Byte.MAX_VALUE;
        }
    }

    private static void handleIntOverflow() {
        if (currentSum > Integer.MAX_VALUE) {
            print(String.valueOf(Integer.MAX_VALUE));
            currentSum = currentSum - Integer.MAX_VALUE;
        }
    }
}
