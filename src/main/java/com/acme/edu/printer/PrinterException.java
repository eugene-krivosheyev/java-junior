package com.acme.edu.printer;

/**
 * Created by Павел on 06.11.2015.
 */
public class PrinterException extends Exception {

    /**
     *
     * @param message the message that encountered the exception
     * @param cause type exception
     */
    public PrinterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * An empty constructor
     */
    public PrinterException() {
        super();
    }
}
