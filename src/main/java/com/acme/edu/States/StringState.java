package com.acme.edu.states;

import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Created by Павел on 02.11.2015.
 */
public class StringState implements LoggerState {

    //region fiends
    private Printable printer[];
    private static String previousLine = "";
    private int buffer = 1;
    //endregion

    //region constructor

    /**
     * Setting the object Printer
     *
     * @param printer
     */
    public StringState(Printable... printer) {
        this.printer = printer;
    }
    //endregion

    //region methods

    /**
     * Counts the number of duplicate rows in a buffer.
     * If there are no duplicates, then the buffer is reset.
     *
     * @param message
     */
    @Override
    public void log(String message) throws StateException{
        if (previousLine.equals(message)) {
            buffer++;
        } else if (previousLine != "") {
            flush();
        }
        previousLine = message;
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() throws StateException{
        try {
            if (buffer == 1 && !previousLine.isEmpty()) {
                for (Printable printable : printer) {
                    printable.print(STRING + previousLine);
                }
            } else if (buffer > 1) {
                for (Printable printable : printer) {
                    printable.print(String.format("%s%s (x%d)", STRING, previousLine, buffer));
                }
            }
        } catch (PrinterException e) {
            throw new StateException(e);
        }
        buffer = 1;
        previousLine = "";
    }
    //endregion
}
