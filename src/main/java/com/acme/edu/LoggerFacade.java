package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.LogSaver;

/**
 * Facade for logger. Gets different types of message and
 * redirects to specific AbstractMessage implementation.
 * Integer, byte and string messages are being saved to
 * log list in controller for further flush.
 *
 * @version 1.0.3
 */
public class LoggerFacade {
    static LoggerController controller = new LoggerController(new LogSaver());

    /**
     * @param  message  a value to be logged
     * @see AbstractMessage
     */
    public static void log(int message) {
        controller.addToLogList(message);
    }

    public static void log(byte message) {
        controller.addToLogList(message);
    }

    public static void log(String message) {
        controller.addToLogList(message);
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BoolMessage(message));
    }

    public static void log(int[] message) {
        controller.log(new ArrayMessage(message));
    }

    public static void log(int[][] message) {
        controller.log(new MatrixMessage(message));
    }

    public static void log(int[][][][] message) {
        controller.log(new MultiMatrixMessage(message));
    }


    /**
     * Section for flush interface. Flush in necessary at the end of work!
     */
    public static void flushStart() {
        controller.flushStart();
    }
}