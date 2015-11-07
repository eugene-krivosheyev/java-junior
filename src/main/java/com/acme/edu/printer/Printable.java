package com.acme.edu.printer;

/**
 * Data output
 */
public interface Printable {
    /**
     * print to console
     * @param message
     */
    void print(String message) throws PrinterException;

    /**
     * The exception to all the printers, accumulates different types of exceptions
     */
    PrinterException printerException = new PrinterException();
}
