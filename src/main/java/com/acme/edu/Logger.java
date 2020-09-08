package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.save.ConsoleSaver;

/**
 * Accumulation <-- message type
 * Decoration <-- message type
 * Flush decision <-- controller state
 * Saving - one point
 */

public class Logger {               //LoggerFacade
    private static LoggerController controller = new LoggerController(new ConsoleSaver());

    public static void log(int message)
    {
        controller.log(new IntCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }


    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanCommand(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectCommand(message));
    }

    public static void log(int[] arrayMessage) {
        controller.log(new ArrayCommand(arrayMessage));
    }

    public static void log(int[][] arrayMessage) {
        controller.log(new MatrixCommand(arrayMessage));
    }

    public static void flush() {
        controller.flushBuffers();
    }
}
