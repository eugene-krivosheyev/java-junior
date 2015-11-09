package com.acme.edu.printer;

import java.io.IOException;

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

    public PrinterException(Throwable cause) {
        super(cause);
    }

    /**
     * An empty constructor
     * @param e
     */
    public PrinterException(IOException e) {
        super();
    }
}
