package com.acme.edu;

import com.acme.edu.exception.LoggerException;
import com.acme.edu.message.*;

/**
 * Facade for logger. Gets different types of message and
 * redirects to specific AbstractMessage implementation.
 *
 * @version 2.0.0
 */
public class LoggerFacade {
    static LoggerController controller = new LoggerController(
            message -> System.out.println(message.getPreparedMessage())
    );

    /**
     * @param  message  a value to be logged
     * @see AbstractMessage
     */
    public static void log(int message) throws LoggerException {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) throws LoggerException {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) throws LoggerException {
        controller.log(new StringMessage(message));
    }

    public static void log(char message) throws LoggerException {
        controller.log(new CharMessage(message));
    }

    public static void log(Object message) throws LoggerException {
        controller.log(new ReferenceMessage(message));
    }

    public static void log(boolean message) throws LoggerException {
        controller.log(new BoolMessage(message));
    }

    public static void log(int[] message) throws LoggerException {
        controller.log(new ArrayMessage(message));
    }

    public static void log(int[][] message) throws LoggerException {
        controller.log(new MatrixMessage(message));
    }

    public static void log(int[][][][] message) throws LoggerException {
        controller.log(new MultiMatrixMessage(message));
    }


    /**
     * Section for flush interface.
     * Flush is necessary in the end of work or in case of switching types.
     */
    public static void flush() throws LoggerException {
        controller.flush();
    }
}