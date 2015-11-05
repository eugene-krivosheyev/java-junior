package com.acme.edu.printer;


import com.acme.edu.LogException;

/**
 * The output in the console
 */
public class Printer implements Printable {
    @Override
    /**
     * print to console
     * @param message The <code>String</code> to be printed.
     */

    public void print(String message) throws PrinterException {
        System.out.println(message);
    }
}
