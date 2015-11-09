package com.acme.edu.states;

import com.acme.edu.logger.LoggerState;
import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Created by Павел on 02.11.2015.
 */
public class UnBufferState extends LoggerState {

    //region constructor
    //for testability
    /**
     * Initialization of types of printing
     * @param printers vararg types printers
     */
    public UnBufferState(Printable... printers) {
        super(printers);
    }

    //endregion

    /**
     * Print message
     *
     * @param
     */
    @Override
    public void log(String message) throws PrinterException {
        printState(message);
    }

    /**
     * Leak abstraction
     */
    @Override
    public void flush() {

    }
    //endregion

}
