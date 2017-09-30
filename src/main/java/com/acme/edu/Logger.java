package com.acme.edu;

import java.util.ArrayList;

/** Simple logger program. */
public class Logger {

    /** Types os messages. */
    private static final String
            MSG_TYPE_BOOLEAN    = "boolean",
            MSG_TYPE_BYTE       = "byte",
            MSG_TYPE_INTEGER    = "integer",
            MSG_TYPE_CHAR       = "char",
            MSG_TYPE_STRING     = "string",
            MSG_TYPE_OBJECT     = "reference";

    /** Prefix for each message content type. */
    private static final String
            PREFIX_PRIMITIVE = "primitive: ",
            PREFIX_CHAR      = "char: ",
            PREFIX_STRING    = "string: ",
            PREFIX_REFERENCE = "reference: ";

    /** Current and previous state of message type.  */
    private static String
            currentMsgType  = null,
            previousMsgType = null;

    /** Complete string for output. */
    private static StringBuilder sb = new StringBuilder();

    /** */
    private static int sumBytes = 0;

    /** */
    private static int sumInts = 0;



    /** */
    private static int strCounter = 0;

    /** */
    public static void log(char message) {

        if (previousMsgType == null) {
            previousMsgType = "char";
            currentMsgType  = "char";
            sb.append(PREFIX_CHAR).append(String.valueOf(message)).append("\n");
        } else if (previousMsgType.equals("char")) {
            sb.append(PREFIX_CHAR).append(String.valueOf(message)).append("\n");
        }


    }

    /** */
    public static void log(byte message) {
        sb.append(PREFIX_PRIMITIVE).append(String.valueOf(message)).append("\n");
    }

    /** */
    public static void log(short message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(int message) {
        sb.append(PREFIX_PRIMITIVE).append(String.valueOf(message)).append("\n");
    }

    /** */
    public static void log(long message) {
        System.out.println("primitive: " + message);
    }

    /** */
    public static void log(boolean message) {
        sb.append(PREFIX_PRIMITIVE).append(String.valueOf(message)).append("\n");
    }

    /** */
    public static void log(String message) {
        sb.append(PREFIX_STRING).append(String.valueOf(message)).append("\n");
    }

    /** */
    public static void log(Object message) {
        sb.append(PREFIX_REFERENCE).append(String.valueOf(message)).append("\n");
    }

    /** */
    private static void clear() {
        sb = null;
        sb = new StringBuilder();
    }

    /** */
    public static void stop() {
        System.out.printf("%s", sb.toString());
        clear();
    }
}
