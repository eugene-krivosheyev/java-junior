package com.acme.edu;


public class Logger {
    static long sumInt;
    static byte versionSumInt;
    static String strToPrint;
    static byte strRepeats;

    public static void setSumInt(long sumInt) {
        Logger.sumInt += sumInt;
        versionSumInt++;
    }

    public static void eraseSumInt(){
        sumInt = 0;
        versionSumInt = 0;
    }

    public static void setStrToPrint(String message) {
        if (message != strToPrint) {
            flush(false);
            strToPrint = message;
            strRepeats = 1;
        } else {
            strRepeats++;
        }

    }

    //region Integer and Byte


    public static void flush(final boolean isIntFlush) {

        if (isIntFlush){
            if (versionSumInt > 0 ) {
                output("primitive: " + sumInt);
                eraseSumInt();
                strToPrint = null;
            }
        } else {

            if (strToPrint != null){
                if (strRepeats == 1) {
                    output("string: " + strToPrint);
                } else {
                    output("string: " + strToPrint +" (x" + strRepeats + ")");
                }

            }
        }
    }

    public static void log(int message) {
        flush(false);
        setSumInt(message);
    }

    public static void log(int message, long maxVal) {
        flush(false);
        if (maxVal >= sumInt + message) {
            setSumInt(message);
        } else {
            flush(true);
            //log(maxVal);
            setSumInt(message);
        }
    }

/*    public static void log(byte message) {
        output("primitive: " + message);
    } */

// endregion



    public static void log(char message) {
        output("char: " + message);
    }

    public static void log(String message) {
        flush(true);
        setStrToPrint(message);
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
}
