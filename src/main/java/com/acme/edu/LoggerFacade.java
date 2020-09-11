package com.acme.edu;

import com.acme.edu.exception.LoggerControllerException;
import com.acme.edu.message.*;
import com.acme.edu.saver.LogSaver;

/**
 * Facade for logger. Gets different types of message and
 * redirects to specific AbstractMessage implementation.
 *
 * @version 2.0.0
 */
public class LoggerFacade {
    static LoggerController controller = new LoggerController(a -> System.out.println(a.getPreparedMessage()));

    /**
     * @param  message  a value to be logged
     * @see AbstractMessage
     */
    public static void log(int message) throws LoggerControllerException {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) throws LoggerControllerException {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) throws LoggerControllerException {
        controller.log(new StringMessage(message));
    }

    public static void log(char message) throws LoggerControllerException {
        controller.log(new CharMessage(message));
    }

    public static void log(Object message) throws LoggerControllerException {
        controller.log(new ReferenceMessage(message));
    }

    public static void log(boolean message) throws LoggerControllerException {
        controller.log(new BoolMessage(message));
    }

    public static void log(int[] message) throws LoggerControllerException {
        controller.log(new ArrayMessage(message));
    }

    public static void log(int[][] message) throws LoggerControllerException {
        controller.log(new MatrixMessage(message));
    }

    public static void log(int[][][][] message) throws LoggerControllerException {
        controller.log(new MultiMatrixMessage(message));
    }


    /**
     * Section for flush interface.
     * Flush in necessary at the end of work or in case of switching types.
     */
    public static void flushStart() throws LoggerControllerException {
        controller.flushStart();
    }
}