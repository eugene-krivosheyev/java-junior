package com.acme.edu.logger;

/** Simple logger program. */
public class LoggerCore {

    /** Types of messages. */
    private static final String
            MSG_TYPE_BOOLEAN    = "boolean",
            MSG_TYPE_BYTE       = "byte",
            MSG_TYPE_INTEGER    = "integer",
            MSG_TYPE_CHAR       = "char",
            MSG_TYPE_STRING     = "string",
            MSG_TYPE_OBJECT     = "reference",

            MSG_TYPE_CHANGED    = "changed";

    /** Prefix for each message content type. */
    private static final String
            PREFIX_PRIMITIVE = "primitive: ",
            PREFIX_CHAR      = "char: ",
            PREFIX_STRING    = "string: ",
            PREFIX_REFERENCE = "reference: ";

    /** Current and previous state of message type.  */
    private static String
            currentMsgType  = null,
            previousMsgType = null,
            newline         = "\n";

    /** Complete string for output. */
    private static StringBuilder output = new StringBuilder();

    /** Has the type of message changed. */
    private static boolean typeWillChanged = false;

    /** Summary bytes of log message. */
    private static int sumBytes = 0;

    /** Summary integers of log messages. */
    private static int sumIntegers = 0;

    /** Counter of strings. */
    private static int strCounter = 0;

    /**
     * Log of the message at char type.
     * @param message message.
     */
    public static void log(char message) {

        if ( ! typeWillChanged ) {

            output.append(PREFIX_CHAR).append(String.valueOf(message)).append("\n");

        } else {
            if (previousMsgType == null) {
                previousMsgType = MSG_TYPE_CHAR;
            } else if (previousMsgType.equals(MSG_TYPE_CHAR)) {
                output.append(PREFIX_CHAR).append(String.valueOf(message)).append("\n");
            } else if ( ! previousMsgType.equals(MSG_TYPE_CHAR) ) {
                output.append(PREFIX_CHAR).append(String.valueOf(message)).append("\n");
            }
            currentMsgType = MSG_TYPE_CHAR;
        }
    }

    /**
     * Log of the message at byte type.
     * @param message message.
     */
    public static void log(byte message) {

        if ( ! typeWillChanged ) {

            output.append(PREFIX_PRIMITIVE).append(String.valueOf(message)).append("\n");

        } else {
            currentMsgType = MSG_TYPE_BYTE;
        }
    }

    /**
     * Log of the message at short type.
     * @param message message.
     */
    public static void log(short message) {

        if ( ! typeWillChanged ) {

            System.out.println("primitive: " + message);

        } else {
            // TODO : something.
        }
    }

    /**
     * Log of the message at integer type.
     * @param message message.
     */
    public static void log(int message) {

        if ( ! typeWillChanged ) {

            output.append(PREFIX_PRIMITIVE).append(String.valueOf(message)).append("\n");

        } else {

            if (previousMsgType == null) {
            } else if (previousMsgType.equals(MSG_TYPE_INTEGER)) {
                sumIntegers += message;
            } else if (previousMsgType.equals(MSG_TYPE_INTEGER) && currentMsgType.equals(MSG_TYPE_CHANGED)) {
                output.append(String.valueOf(sumIntegers)).append(newline);
                sumIntegers = 0;
            } else if (currentMsgType.equals(MSG_TYPE_CHANGED)) {
                currentMsgType = MSG_TYPE_INTEGER;
                sumIntegers += message;
            }
            previousMsgType = currentMsgType;
        }
    }

    /**
     * Log of the message at long type.
     * @param message message.
     */
    public static void log(long message) {

        if ( ! typeWillChanged ) {

            System.out.println("primitive: " + message);

        } else {
            // TODO : something.
        }
    }

    /** Log of the message at boolean type. */
    public static void log(boolean message) {


        if ( ! typeWillChanged ) {

            output.append(PREFIX_PRIMITIVE).append(String.valueOf(message)).append("\n");

        } else {
            currentMsgType = MSG_TYPE_BOOLEAN;
        }
    }

    /** Log of the message at string type. */
    public static void log(String message) {

        if ( ! typeWillChanged ) {

            output.append(PREFIX_STRING).append(String.valueOf(message)).append("\n");

        } else {
            if (previousMsgType == null) {
                output.append(message).append(newline);
            } else if ( ! previousMsgType.equals(MSG_TYPE_STRING)) {
                output.append(message).append(newline);
            } else if (currentMsgType.equals(MSG_TYPE_STRING)) {
                output.append(message).append(newline);
            }
        }
        currentMsgType  = MSG_TYPE_STRING;
        previousMsgType = currentMsgType;
    }

    /** Log of the message at object type. */
    public static void log(Object message) {

        if ( ! typeWillChanged ) {

            output.append(PREFIX_REFERENCE).append(String.valueOf(message)).append("\n");

        } else {
            currentMsgType = MSG_TYPE_OBJECT;
        }
    }

    /** Type of message will changed. */
    public static void typeShouldChanged() {
        typeWillChanged = true;
    }

    /** Change the state of type message. */
    public static void change() {
        previousMsgType = currentMsgType;
        currentMsgType  = MSG_TYPE_CHANGED;
        typeWillChanged = true;

        if (previousMsgType.equals(MSG_TYPE_INTEGER)) {
            output.append(String.valueOf(sumIntegers));
        } else if (previousMsgType.equals(MSG_TYPE_BYTE)) {
            output.append(String.valueOf(sumBytes));
        }
    }

    /** Clear the complete string of output. */
    private static void clear() {
        output = null;
        output = new StringBuilder();
    }

    /** Stop the log. */
    public static void stop() {
        System.out.printf("%s", output.toString());
        clear();
    }
}
