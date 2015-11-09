package com.acme.edu.logger;

import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Contains prefix and behavior of logger
 */
public abstract class LoggerState{

    //region constants
    /**
     * An array of types of printing
     */
    static Printable[] printers;
    public static final String STRING = "string: ";
    public static final String PRIMITIVE = "primitive: ";
    //endregion

    /**
     * Initialization of types of printing
     * @param varargPrinters
     */
    public LoggerState(Printable[] varargPrinters) {
        printers = varargPrinters;
    }
    /**
     * Print message
     * @param message
     */
    public abstract void log(String message) throws  PrinterException;

    /**
     * Clearing buffers
     */
    public abstract void flush() throws  PrinterException;

    /**
     * printing messages in different places: to file, to console, the file on the server
     * @param message
     * @throws PrinterException
     */
    public void printState(String message) throws PrinterException {
        for (Printable printable : printers) {
            printable.print(message);
        }
    }
}