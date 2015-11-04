package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class StringState implements LoggerState {

    //region fiends
    private Printer printer;
    private static String previousLine = "";
    private int buffer = 1;
    //endregion

    //region constructor
    /**
     * Setting the object Printer
     * @param printer
     */
    public StringState(Printer printer) {
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
    public void log(String message) {
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
    public void flush() {
        if (buffer == 1 && !previousLine.isEmpty()){
            printer.print(STRING + previousLine);
        }else if(buffer > 1 ){
            printer.print(String.format("%s%s (x%d)", STRING, previousLine, buffer));
        }
        buffer = 1;
        previousLine = "";
    }
    //endregion

    //region leak abstractions

    /**
     * Leak abstractions
     * @param array
     */
    @Override
    public void log(int[] array) {
        return;
    }

    /**
     * Leak abstractions
     * @param matrix
     */
    @Override
    public void log(int[][] matrix) {
        throw new UnsupportedOperationException();
    }

    /**
     * Leak abstractions
     * @param multiMatrix
     */
    @Override
    public void log(int[][][][] multiMatrix) {
        throw new UnsupportedOperationException();
    }

    /**
     * Leak abstractions
     * @param elements
     */
    @Override
    public void log(String... elements) {
        return;
    }
    //endregion
}
