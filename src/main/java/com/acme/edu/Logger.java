package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.exception.LogException;
import com.acme.edu.saver.FileSaver;

/**
 * The Logger class provides wrapper methods for logging int or String messages
 *
 * @see LoggerController
 */

public class Logger {

    private static LoggerController loggerController = new LoggerController(System.out::println, new FileSaver("logger.txt"));

    /**
     * Wrapper method for flush() implemented in LoggerController
     *
     * @see LoggerController
     */
    public static void flush() {
        loggerController.flush(null);
    }

    /**
     * Wrapper method for log() implemented in LoggerController
     *
     * @param message an int message for logging
     * @see LoggerController
     */
    public static void log(int message) {
        try {
            loggerController.log(new IntCommand(message));
        } catch (LogException e) {
            System.out.println("Can't log message. Exception was thrown caused by" + e.getCause() +
                    " with message " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Wrapper method for log() implemented in LoggerController
     *
     * @param message a String message for logging
     * @see LoggerController
     */
    public static void log(String message) {
        try {
            loggerController.log(new StringCommand(message));
        } catch (LogException e) {
            System.out.println("Can't log message. Exception was thrown caused by" + e.getCause() +
                    " with message " + e.getMessage());
            e.printStackTrace();
        }
    }

}
