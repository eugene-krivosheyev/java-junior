package com.acme.edu;

/**
 * The best logger ever.
 */
public final class Logger {
    private static MessageProcessor previousProcessor;
    private static final MessageProcessor<Byte> BYTE_PROCESSOR = new ByteMessageProcessor();
    private static final MessageProcessor<Boolean> BOOLEAN_PROCESSOR = new DefaultMessageProcessor<>("primitive: %s\n");
    private static final MessageProcessor<Character> CHAR_PROCESSOR = new DefaultMessageProcessor<>("char: %s\n");
    private static final MessageProcessor<Integer> INTEGER_PROCESSOR = new IntegerMessageProcessor();
    private static final MessageProcessor<String> STRING_PROCESSOR = new StringMessageProcessor();
    private static final MessageProcessor<Object> OBJECT_PROCESSOR = new DefaultMessageProcessor<>("reference: %s\n");

    private Logger() {
    }

    /**
     * Log boolean type message
     * @param message value to be logged
     */
    public static void log(Boolean message) {
        previousProcessor = log(previousProcessor, BOOLEAN_PROCESSOR, message);
    }

    /**
     * Log byte type message
     * @param message value to be logged
     */
    public static void log(Byte message) {
        previousProcessor = log(previousProcessor, BYTE_PROCESSOR, message);
    }

    /**
     * Log char type message
     * @param message value to be logged
     */
    public static void log(Character message) {
        previousProcessor = log(previousProcessor, CHAR_PROCESSOR, message);
    }

    /**
     * Log integer type message
     * @param message value to be logged
     */
    public static void log(Integer message) {
        previousProcessor = log(previousProcessor, INTEGER_PROCESSOR, message);
    }

    /**
     * Log string type message
     * @param message value to be logged
     */
    public static void log(String message) {
        previousProcessor = log(previousProcessor, STRING_PROCESSOR, message);
    }

    /**
     * Log reference type message
     * @param message value to be logged
     */
    public static void log(Object message) {
        previousProcessor = log(previousProcessor, OBJECT_PROCESSOR, message);
    }

    private static <T> MessageProcessor<T> log(MessageProcessor previous, MessageProcessor<T> current, T message) {
        if (previous != null && !previous.equals(current)) {
            previous.flush();
        }
        current.process(message);
        return current;
    }

    public static void flush() {
        if (previousProcessor != null) {
            previousProcessor.flush();
        }
    }
}
