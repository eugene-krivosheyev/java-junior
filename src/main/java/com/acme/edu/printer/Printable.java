package com.acme.edu.printer;

import com.acme.edu.exception.PrinterException;

/**
 * Data output
 */
public interface Printable {
    /**
     * print to console
     * @param message
     */
    void print(String message) throws PrinterException;
}
