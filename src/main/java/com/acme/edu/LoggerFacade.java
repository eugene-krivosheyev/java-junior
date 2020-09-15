package com.acme.edu;

import com.acme.edu.exception.LoggerException;
import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.FileSaver;

/**
 * Facade for logger.
 * Gets different types of message and redirects to specific
 * AbstractMessage implementation for further logging in controller.
 *
 * @version 3.0.0
 */
public class LoggerFacade {
    private static final LoggerController controller =
            new LoggerController(new ConsoleSaver(), new FileSaver("test.txt"));

    /**
     * @param  message AbstractMessage value to be logged
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

    public static void end() throws LoggerException {
        controller.end();
    }


    /**
     * Section for flush interface.
     * Should be called when client doesn't want to concatenate some
     * consecutive log messages of the same type.
     *
     * Warning: flush is necessary in the end of work!
     */
    public static void flush() throws LoggerException {
        controller.flush();
    }
}