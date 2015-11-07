package com.acme.edu.printer;

/**
 * The output in the console
 */
public class ConsolePrinter implements Printable {

    /**
     * print to console
     * @param message The <code>String</code> to be printed.
     */
    public void print(String message) throws PrinterException {
        System.out.println(message);
    }
}
