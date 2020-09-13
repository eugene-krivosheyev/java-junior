package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.exceptions.LogException;
import com.acme.edu.exceptions.TypeCommandException;
import com.acme.edu.save.ConsoleSaver;

/**
 * Accumulation <-- message type
 * Decoration <-- message type
 * Flush decision <-- controller state
 * Saving - one point
 */

public class Logger {               //LoggerFacade
    private static LoggerController controller = new LoggerController(new ConsoleSaver());

    public static void log(int message) throws LogException {
        controller.log(new IntCommand(message));
    }

    public static void log(String message) throws LogException {
        controller.log(new StringCommand(message));
    }

    public static void log(int[] arrayMessage) throws LogException {
        controller.log(new ArrayCommand(arrayMessage));
    }

    public static void log(int[][] arrayMessage) throws LogException {
        controller.log(new MatrixCommand(arrayMessage));
    }

    public static void flush() {
        controller.flushBuffers();
    }
}
