package com.acme.edu.states;

import com.acme.edu.printer.Printable;

/**
 * Contains prefix and behavior of logger
 */
public abstract class LoggerState{

    //region constants
    public static String CHAR = "char: ";
    public static String STRING = "string: ";
    public static String REFERENCE = "reference: ";
    public static String PRIMITIVE = "primitive: ";
    public static String SEP = System.lineSeparator();

    public static Printable[] printers = null;

    public LoggerState(Printable[] VarargPrinters) {
        printers = VarargPrinters;
    }

    public LoggerState(){}

    public Printable[] getPrinters() {
        return printers;
    }

    //endregion

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