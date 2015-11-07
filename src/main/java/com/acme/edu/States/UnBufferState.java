package com.acme.edu.states;

import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Created by Павел on 02.11.2015.
 */
public class UnBufferState extends LoggerState {

    //region constructor
    //for testability
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
    public void log(String message) throws StateException{
        for (Printable printable : getPrinters()) {
            try {
                printable.print(message);
            }catch (PrinterException e){
                throw new StateException(e);
            }
        }
    }

    /**
     * Leak abstraction
     */
    @Override
    public void flush() {
        return;
    }
    //endregion

}
