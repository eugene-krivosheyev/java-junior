package com.acme.edu;

public class Logger {
    private static long integerChainSum;
    private static int stringChainSum = 0;
    private static StringBuffer stringBuffer;

    public static void flushIntegerBuffer() {
        if (integerChainSum != 0) {
        output("primitive: " + integerChainSum);
        integerChainSum = 0;
        }
    }

    public static void flushStringBuffer() {
        if (stringBuffer != null) {
            if (stringChainSum > 1) {
                output("string: " + stringBuffer + " (x" + stringChainSum + ")");
                stringChainSum = 0;
                stringBuffer = null;
            } else {
                output("string: " + stringBuffer);
                stringChainSum = 0;
                stringBuffer = null;
            }
        }
    }

    public static void log(int message) {
        flushStringBuffer();
        if (message == 0 && integerChainSum == 0) {
            output("primitive: " + message);
        } else if (integerChainSum + message > Integer.MAX_VALUE) {
            integerChainSum += message % Integer.MAX_VALUE;
            flushIntegerBuffer();
            long messageRemainder = message - (message % Integer.MAX_VALUE);
            while (messageRemainder >= Integer.MAX_VALUE) {
                integerChainSum += Integer.MAX_VALUE;
                flushIntegerBuffer();
                messageRemainder -= Integer.MAX_VALUE;
            }
        } else {
            integerChainSum += message;
        }
    }

    public static void log(byte message) {
        flushBuffers();
        int byteOverflowContainer =  message ;
        if (byteOverflowContainer + message > Byte.MAX_VALUE) {
            byteOverflowContainer += message % Byte.MAX_VALUE;
            output("Primitive: " + byteOverflowContainer);
            int messageRemainder = message - (message % Byte.MAX_VALUE);
            while (messageRemainder >= Byte.MAX_VALUE) {
                output("Primitive: " + Byte.MAX_VALUE);
                messageRemainder -= Byte.MAX_VALUE;
            }
        } else {
            output("primitive: " + message);
        }
    }

    public static void log(char message) {
        flushBuffers();
        output("char: " + message);
    }

    public static void log(String message) {
        flushIntegerBuffer();
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer(message);
            stringChainSum += 1;
        } else if (stringBuffer.toString().equals(message)) {
            stringChainSum += 1;
        } else {
            flushStringBuffer();
            stringBuffer = new StringBuffer(message);
            stringChainSum += 1;
        }
    }

    public static void log(boolean message) {
        flushBuffers();
        output("primitive: " + message);
    }

    public static void log(Object message) {
        flushBuffers();
        output("reference: " + message);
    }

    private static void flushBuffers() {
        flushStringBuffer();
        flushIntegerBuffer();
    }

    private static void output(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
