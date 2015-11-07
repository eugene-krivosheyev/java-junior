package com.acme.edu.states;

import com.acme.edu.printer.Printable;

/**
 * Contains prefix and behavior of logger
 */
public abstract class LoggerState{

    //region constants
    /**
     * An array of types of printing
     */
    public static Printable[] printers = null;
    static final String STRING = "string: ";
    static final String PRIMITIVE = "primitive: ";
    //endregion

    /**
     * Initialization of types of printing
     * @param VarargPrinters
     */
    public LoggerState(Printable[] VarargPrinters) {
        printers = VarargPrinters;
    }

    /**
     * @return array types printer
     */
    public Printable[] getPrinters() {
        return printers;
    }

    /**
     * Print message
     * @param message
     */
    public abstract void log(String message) throws StateException;

    /**
     * Clearing buffers
     */
    public abstract void flush() throws StateException;
}