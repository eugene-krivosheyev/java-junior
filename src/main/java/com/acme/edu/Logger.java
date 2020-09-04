package com.acme.edu;

public class Logger {

    public static int IntBuffer = 0;
    public static int ByteBuffer = 0;
    public static int StringBuffer = 0;
    public static String PreviousType = "";
    public static String PreviousString = "";
    public static String PreviousMessage = "";


    public static void log(int message) {
        IntBuffer += message;
        if (!PreviousType.equals(((Object) message).getClass().getName())) {
            flushBuffers();
        }
        PreviousType = ((Object) message).getClass().getName();
    }

    public static void log(byte message) {
        ByteBuffer += message;
        if (!PreviousType.equals(((Object) message).getClass().getName())) {
            flushBuffers();
        }
        PreviousType = ((Object) message).getClass().getName();
    }

    public static void log(char message) {
        printLogMessage("" + message);
    }

    public static void log(String message) {
        if (!PreviousType.equals(((Object) message).getClass().getName()) || !PreviousString.equals(message)) {
            flushBuffers();
        }
        if (PreviousString.equals(message)) {
            StringBuffer += 1;
        }
        PreviousType = ((Object) message).getClass().getName();
        if (StringBuffer == 0) {
            PreviousString = message;
            PreviousMessage = message;
            StringBuffer++;
        }
    }

    public static void log(boolean message) {
        printLogMessage("" + message);
    }

    public static void log(Object message) {
        printLogMessage("" + message);
    }

    public static void printLogMessage(Object message) {
        System.out.println(message.toString());
    }

    public static void flushBuffers() {
        switch (PreviousType) {
            case "java.lang.String":
                if (StringBuffer > 1) {
                    printLogMessage(PreviousString + " (x" + StringBuffer + ")");
                }
                else
                    printLogMessage(PreviousString);
                flushString();
                break;
            case "java.lang.Integer":
                printLogMessage(IntBuffer);
                IntBuffer = 0;
                break;
            case "java.lang.Byte":
                printLogMessage(IntBuffer);
                ByteBuffer = 0;
                break;
        }
    }

    public static void flushString() {
         StringBuffer = 0;
         PreviousString = "";
         PreviousMessage = "";
     }


}
