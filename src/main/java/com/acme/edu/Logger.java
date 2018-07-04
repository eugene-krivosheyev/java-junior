package com.acme.edu;

public class Logger {

    //region Integer and Byte
    static long sumInt;


    public static void log(int message) {
        output("primitive: " + message);
    }

    public static void log(int message, long maxVal, boolean isFlush) {
        if (maxVal > sumInt + message) {
            sumInt += message;
        } else {
            log(maxVal);
            sumInt = sumInt + message - maxVal;
        }
        if (isFlush) {
            log(sumInt);
            sumInt = 0;
        }
    }

/*    public static void log(byte message) {
        output("primitive: " + message);
    } */

// endregion

    // region Array
    public static void log(int[] message, boolean hint) {
        StringBuilder stringBuilder = new StringBuilder();
        if (hint) {
            stringBuilder.append("primitives array: ");
        };
        stringBuilder.append("{");
                for (int i = 0; i < message.length; i++) {
                    stringBuilder.append(message[i]);
                    if (i < (message.length - 1)) {
                        stringBuilder.append(", ");
                    }
                }
        stringBuilder.append("}");
        output(stringBuilder.toString());
    }

    public static void log(int[][] message) {
        StringBuilder stringBuilder = new StringBuilder();
        output("primitives matrix: {");
        for (int element[] : message) {
            log(element, false);
        }

        for (int i = 0; i < message.length; i++) {
            stringBuilder.append(message[i]);
            if (i < (message.length - 1)) {
                stringBuilder.append(", ");
            }
        }
        output("}");
    }
    // endregion

    public static void log(char message) {
        output("char: " + message);
    }

    public static void log(String message) {
        output("string: " + message);
    }

    public static void log(boolean message) {
        output("primitive: " + message);
    }

    public static void log(Object message) {
        output("reference: " + message);
    }

    private static void output(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }


}
