package com.acme.edu.printer;

import java.util.Collections;
import java.util.List;

/**
 * Data output
 */
public abstract class PrinterManager {

    //region fields
    String SEP = System.lineSeparator();
    protected static final int SIZE_BUFFER = 50;
    //endregion

    /**
     * print to console
     * @param message
     */
    public abstract void print(String message) throws PrinterException;

    /**
     * Check the buffer at maximum size
     * @param listMessages
     * @return
     */
    public boolean checkBuffer(List<String> listMessages){
        if (listMessages.size() < SIZE_BUFFER){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Sort buffer. Highest priority message with the text "ERROR"
     * @param listMessages
     */
    public void sortBuffer(List<String> listMessages){
        Collections.sort(listMessages, (o1, o2) -> {
            if (o1.contains("ERROR"))
                return -1;
            else if (o1.equals(o2))
                return 0;
            else return 1;
        });
    }

}
