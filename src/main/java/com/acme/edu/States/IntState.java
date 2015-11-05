package com.acme.edu.states;

import com.acme.edu.LogException;
import com.acme.edu.printer.Printable;
import javafx.fxml.LoadException;

/**
 * Created by Павел on 02.11.2015.
 */
public class IntState implements LoggerState {

    //region fields
    private Printable printer;
    private int buffer = 0;
    //endregion

    //region constructor

    /**
     * Setting the object Printer
     *
     * @param printer
     */
    public IntState(Printable printer) {
        this.printer = printer;
    }
    //endregion

    //region methods

    /**
     * Finds the sum of integers
     *
     * @param message
     */
    @Override
    public void log(String message) throws LogException {
        checkMaxAndOverFlow(Integer.parseInt(message));
        buffer += Integer.parseInt(message);
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() throws LogException {
        try {
            printer.print(PRIMITIVE + String.valueOf(buffer));
        } catch (LoadException e) {
            throw new LogException(e);
        }
        buffer = 0;
    }

    private void checkMaxAndOverFlow(int message) throws LogException {
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
