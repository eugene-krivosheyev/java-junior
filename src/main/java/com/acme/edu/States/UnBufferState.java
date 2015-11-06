package com.acme.edu.states;

import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;

/**
 * Created by Павел on 02.11.2015.
 */
public class UnBufferState implements LoggerState {

    //region fields
    private Printable[] printer;
    //endregion

    //region constructor
    /**
     * Setting the object Printer
     *
     * @param printer
     */
    public UnBufferState(Printable... printer) {
        this.printer = printer;
    }
    //endregion

    /**
     * Print message
     * @param
     */
    @Override
    public void log(String message) throws StateException {
        try {
            for (Printable printable : printer) {
                printable.print(message);
            }
        }catch (PrinterException e){
            throw new StateException(e);
        }
    }

    /**
     * Leak abstractions
     */
    @Override
    public void flush(){
        return;
    }
    //endregion

}
