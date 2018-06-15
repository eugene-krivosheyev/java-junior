package com.acme.edu;

/**
 * The best logger ever.
 */
public final class Logger {
    private static final MessageProcessor CHAR_PROCESSOR = new DefaultMessageProcessor("char: %s\n");
    private static final MessageProcessor STRING_PROCESSOR = new DefaultMessageProcessor("string: %s\n");
    private static final MessageProcessor PRIMITIVE_PROCESSOR = new DefaultMessageProcessor("primitive: %s\n");
    private static final MessageProcessor REFERENCE_PROCESSOR = new DefaultMessageProcessor("reference: %s\n");

    private Logger() {
    }

    /**
     * Log boolean type message
     * @param message value to be logged
     */
    public static void log(Boolean message) {
        PRIMITIVE_PROCESSOR.process(message);
    }

    /**
     * Log byte type message
     * @param message value to be logged
     */
    public static void log(Byte message) {
        PRIMITIVE_PROCESSOR.process(message);
    }

    /**
     * Log char type message
     * @param message value to be logged
     */
    public static void log(Character message) {
        CHAR_PROCESSOR.process(message);
    }

    /**
     * Log integer type message
     * @param message value to be logged
     */
    public static void log(Integer message) {
        PRIMITIVE_PROCESSOR.process(message);
    }

    /**
     * Log string type message
     * @param message value to be logged
     */
    public static void log(String message) {
        STRING_PROCESSOR.process(message);
    }

    /**
     * Log reference type message
     * @param message value to be logged
     */
    public static void log(Object message) {
        REFERENCE_PROCESSOR.process(message);
    }
}
