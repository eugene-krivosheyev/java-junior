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
    public static Printable[] printers;
    static final String STRING = "string: ";
    static final String PRIMITIVE = "primitive: ";
    //endregion

    /**
     * Initialization of types of printing
     * @param varargPrinters
     */
    public LoggerState(Printable[] varargPrinters) {
        this.printers = varargPrinters;
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