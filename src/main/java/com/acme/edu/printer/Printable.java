package com.acme.edu.printer;

/**
 * Data output
 */
public interface Printable {

    //region fields
    String SEP = System.lineSeparator();
    int SIZE_BUFFER = 50;
    //endregion

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
