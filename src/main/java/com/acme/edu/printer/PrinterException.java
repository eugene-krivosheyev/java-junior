package com.acme.edu.printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 06.11.2015.
 */
public class PrinterException extends Exception {
    transient List<Throwable> listExciption = new ArrayList<>();
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
