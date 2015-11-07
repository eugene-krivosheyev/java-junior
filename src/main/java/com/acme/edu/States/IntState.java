package com.acme.edu.states;

import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Created by Павел on 02.11.2015.
 */
public class IntState extends LoggerState {

    //region fields
    private int buffer = 0;
    //endregion

    //region constructor
    ///for testability
    public IntState(Printable... printers) {
        super(printers);
    }
    //endregion


    //region methods
    /**
     * Finds the sum of integers
     *
     * @param message
     */
    @Override
    public void log(String message) throws StateException {
        checkMaxAndOverFlow(Integer.parseInt(message));
        buffer += Integer.parseInt(message);
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() throws StateException {
        for (Printable printable : getPrinters()) {
            try {
                printable.print(PRIMITIVE + String.valueOf(buffer));
            } catch (PrinterException e) {
                throw new StateException(e);
            }
        }
        buffer = 0;
    }

    private void checkMaxAndOverFlow(int message) throws StateException {
        if (message == Integer.MAX_VALUE || message == Integer.MIN_VALUE) {
            flush();
        }
        if ((long) message + buffer > Integer.MAX_VALUE) {
            flush();
        }
        if ((long) message + buffer < Integer.MIN_VALUE) {
            flush();
        }
    }
    //endregion
}
