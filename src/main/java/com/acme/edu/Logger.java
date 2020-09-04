package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    private static String final_log = "";

    private static void print(String prefix, Object postfix) {
        final_log = final_log + (prefix + postfix) + System.lineSeparator();
    }

    public static void flush() {
        localFlush();
        System.out.print(final_log);
        final_log = "";
    }

    private static void localFlush() {
        if (previousIsInt)
            print(PRIMITIVE, primitiveSumInt);
        previousIsInt = false;
        primitiveSumInt = 0;

        if (previousIsByte)
            print(PRIMITIVE, primitiveSumByte);
        previousIsByte = false;
        primitiveSumByte = 0;
    }


    private static long primitiveSumInt = 0;
    private static boolean previousIsInt = false;

    public static void log(int message) {
        previousIsInt = true;
        if (primitiveSumInt + message > Integer.MAX_VALUE) {
            print(PRIMITIVE, primitiveSumInt);
            previousIsInt = true;
            primitiveSumInt = message;
        } else {
            primitiveSumInt += message;
        }
    }


    private static int primitiveSumByte = 0;
    private static boolean previousIsByte = false;

    public static void log(byte message) {
        previousIsByte = true;
        if (primitiveSumByte + message > Byte.MAX_VALUE) {
            print(PRIMITIVE, primitiveSumByte);
            previousIsByte = true;
            primitiveSumByte = message;
        } else {
            primitiveSumByte += message;
        }
    }

    public static void log(char message) {
        localFlush();
        print(CHAR, message);
    }

    private static String previousString = "";
    private static int previousStringSum = 0;

    public static void log(String message) {
        if (previousString.equals(message)) {
            previousStringSum += 1;
        } else {
            if (previousStringSum >= 2) {
                print(STRING, message +
                        " (x" + previousStringSum + ")");
                localFlush();
            } else
                print(STRING, message);

            previousStringSum = 0;
        }

        previousString = message;
    }

    public static void log(boolean message) {
        localFlush();
        print(PRIMITIVE, message);
    }

    public static void log(Object message) {
        localFlush();
        print(REFERENCE, message);
    }
}
