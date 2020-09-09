package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {

    private static final LoggerController loggerController = new LoggerController(new ConsoleSaver());

    /**
     * Save decorated message, which is accumulated until this moment
     *
     * @see LoggerController
     */
    public static void postProcessing() {
        loggerController.flush();
    }

    /**
     * Accumulate the content of messages of same type (int)
     * Flush the accumulated value on type switch
     * Decorate the message with prefix
     * Save decorated message to Saver
     *
     * @param message
     */
    public static void log(int message) {
      loggerController.log(new IntMessage(message));
    }

    /**
     * Accumulate the content of messages of same type (String)
     * Flush the accumulated value on type switch
     * Decoration of the message with prefix
     * Saving decorated message to Saver
     *
     * @param message
     */
    public static void log(String message) {
        loggerController.log(new StringMessage(message));
    }


    /**
     * Clears all previous message states
     */
    public static void clearLogger() { loggerController.clearLoggerMessageCache(); }
}
