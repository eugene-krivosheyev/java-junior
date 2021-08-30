package com.acme.edu.ooad;

import com.acme.edu.ooad.controller.LoggerController;
import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.ConsoleSaver;

public class Logger {
    private static final LoggerController controller = new LoggerController(new ConsoleSaver());

    /**
     * Flushes last logged message.
     * Saves last <code>Message</code> for which <code>log</code> method was called.
     * Reset <code>Message counter</code> if necessary.
     */
    public static void flush() {
        controller.flush();
    }

    /**
     * Logs int value cumulatively.
     * Accumulates serial int <code>messages</code> to log sum of them.
     * Overflowing does not handle.
     *
     * @param message  value to accumulate before saving
     * @see #flush()
     * @see #log(byte)
     * @see #log(String)
     */
    public static void log(int message) {
        controller.log(new IntegerMessage(message));
    }

    public static void log(int... integers) {
        for ( int integer: integers ) {
            controller.log(new IntegerMessage(integer));
        }
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(String... strings) {
        for ( String string : strings ) {
            controller.log(new StringMessage(string));
        }
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }
}
