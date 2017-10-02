package com.acme.edu.logger.core.output;

import com.acme.edu.logger.core.output.formatter.ConsoleOutputFormatter;
import com.acme.edu.logger.core.output.formatter.IOutputFormatter;

/**
 * Main logger output.
 *
 * @author Timur Kashapov
 * @since 0.0.1
 */
public class LoggerOutput {

    IOutputFormatter output = new ConsoleOutputFormatter();

    /** Complete string for output. */
    private static StringBuilder complete;

    /** Current active pre-complete string for output. */
    private static StringBuilder active;

    /** */
    public LoggerOutput() {
        complete = new StringBuilder();
        active   = new StringBuilder();
    }

    /** */
    private State activeState;

    /** */
    private enum State { READY, BUSY }

    /**
     * Get not complete string for output.
     * @return active string.
     */
    public String getActiveString() {
        return active.toString();
    }

    /**
     * Get complete string for output.
     * @return complete string.
     */
    public String getCompleteString() {
        return complete.toString();
    }

    /** */
    public void clear() {
        active = complete = null;
    }

    /**
     * Output to ...
     */
    public static void outputTo(/* Data data */) {}
}
