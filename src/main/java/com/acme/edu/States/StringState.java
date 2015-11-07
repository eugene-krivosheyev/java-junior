package com.acme.edu.states;

import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Created by Павел on 02.11.2015.
 */
public class StringState extends LoggerState {

    //region fiends
    private static String previousLine = "";
    private int buffer = 1;
    //endregion

    //region constructor
    //for testability
    /**
     * Initialization of types of printing
     * @param printers vararg types printers
     */
    public StringState(Printable... printers) {
        super(printers);
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
    public void log(String message) throws StateException {
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
    public void flush() throws StateException {

        if (buffer == 1 && !previousLine.isEmpty()) {
            for (Printable printable : getPrinters()) {
                try {
                    printable.print(STRING + previousLine);
                } catch (PrinterException e) {
                    throw new StateException(e);
                }
            }
        } else {
            for (Printable printable : getPrinters()) {
                try {
                    printable.print(String.format("%s%s (x%d)", STRING, previousLine, buffer));
                } catch (PrinterException e) {
                    throw new StateException(e);
                }
            }
        }

        buffer = 1;
        previousLine = "";
    }
    //endregion
}
