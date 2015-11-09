package com.acme.edu.states;

import com.acme.edu.printer.PrinterManager;
import com.acme.edu.printer.PrinterException;

/**
 * Contains prefix and behavior of logger
 */
public abstract class LoggerState{

    //region constants
    /**
     * An array of types of printing
     */
    private static PrinterManager[] printers;
    public static final String STRING = "string: ";
    public static final String PRIMITIVE = "primitive: ";
    //endregion

    /**
     * Initialization of types of printing
     * @param varargPrinters
     */
    public LoggerState(PrinterManager[] varargPrinters) {
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
        for (PrinterManager printerManager : printers) {
            printerManager.print(message);
        }
    }

    /**
     * Initialization sets printer
     * @param printers
     */
    public static void setPrinters(PrinterManager[] printers) {
        LoggerState.printers = printers;
    }
}