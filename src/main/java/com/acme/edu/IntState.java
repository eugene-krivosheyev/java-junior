package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class IntState implements LoggerState{

    //region fields
    private Printable printer;
    private int buffer = 0;
    //endregion

    //region constructor
    /**
     * Setting the object Printer
     * @param printer
     */
    public IntState(Printable printer) {
        this.printer = printer;
    }
    //endregion

    //region methods
    /**
     * Finds the sum of integers
     * @param message
     */
    @Override
    public void log(String message) {
        checkMaxAndOverFlow(Integer.parseInt(message));
        buffer += Integer.parseInt(message);
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() {
            printer.print(PRIMITIVE + String.valueOf(buffer));
            buffer = 0;
    }

    private void checkMaxAndOverFlow(int message) {
        if (message == Integer.MAX_VALUE || message == Integer.MIN_VALUE) {
            flush();
        }

        if ((long)message + buffer  > Integer.MAX_VALUE ){
            flush();
        }
        if ((long)message + buffer  < Integer.MIN_VALUE ){
            flush();
        }
    }
    //endregion
}
