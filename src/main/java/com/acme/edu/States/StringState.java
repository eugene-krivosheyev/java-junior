package com.acme.edu.states;

import com.acme.edu.exceptions.LogException;
import com.acme.edu.printer.Printable;
import javafx.fxml.LoadException;

/**
 * Created by Павел on 02.11.2015.
 */
public class StringState implements LoggerState {

    //region fiends
    private Printable printer;
    private static String previousLine = "";
    private int buffer = 1;
    //endregion

    //region constructor
    /**
     * Setting the object Printer
     * @param printer
     */
    public StringState(Printable printer) {
        this.printer = printer;
    }
    //endregion

    //region methods

    /**
     * Counts the number of duplicate rows in a buffer.
     * If there are no duplicates, then the buffer is reset.
     * @param message
     */
    @Override
    public void log(String message) throws LogException {
        if (previousLine.equals(message)){
            buffer++;
        }else if (previousLine != ""){
            flush();
        }
        previousLine = message;
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() throws LogException {
        if (buffer == 1 && !previousLine.isEmpty()){
            try {
                printer.print(STRING + previousLine);
            }catch (LoadException e){
                throw new LogException(e);
            }
        }else if(buffer > 1 ){
            try {
                printer.print(String.format("%s%s (x%d)", STRING, previousLine, buffer));
            }catch (LoadException e){
                throw new LogException(e);
            }
        }
        buffer = 1;
        previousLine = "";
    }
    //endregion
}
