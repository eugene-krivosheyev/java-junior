package com.acme.edu;

/**
 * Class Log method overload
 * Type conversion
 * @version 1.1 2 Nov 2015
 * @author Pavel Seregin
 */
public class Logger implements LoggerState {

    //region fields
    Printer printer;
    Factory factory;
    //endregion

    //region constructor
    /**
     * Setting the object Printer
     * @param printer
     */
    public Logger(Printer printer) {
        this.printer = printer;
    }

    public Logger(Printer printer, Factory factory){
        this.printer = printer;
        this.factory = factory;
    }
    //endregion

    //region methods
    /**
     * Print duplicate rows.
     * If no duplicates, prints one line.
     * Considers the sum of consecutive integers,
     * If numbers are not consecutive, print the input value.
     * @param message The <code>primitive: int</code> to be printed.
     */
    public void log(int message) {
        if (factory.getState() == LoggerStateHolder.SIMPLE_PRINT){
            factory.setIntState();
        }else if (factory.getState() == LoggerStateHolder.SUM_INTEGERS) {
            factory.loggerState.log(String.valueOf(message));
        }else if (factory.getState() == LoggerStateHolder.STRING_REPEAITING){
            factory.loggerState.flush();
            factory.setIntState();
            factory.loggerState.log(String.valueOf(message));
        }
    }

    /**
     * Prints an boolean and prefix of the "primitive: "
     * @param message The <code>primitive: boolean</code> to be printed.
     */
    public void log(boolean message) {
        printer.print(Logger.PRIMITIVE + message);
    }

    /**
     * Prints an char and prefix of the "char: "
     * @param message The <code>char: char</code> to be printed.
     */
    public void log(char message) {
        printer.print(Logger.CHAR + message);
    }

    /**
     * Prints an Object and prefix of the "reference: "
     * @param message The <code>reference: Object</code> to be printed.
     */
    public void log(Object message) {
        printer.print(Logger.REFERENCE + message);
    }

    /**
     * Print the sum of consecutive integers and prefix of the "primitive: "
     * Print string and considers the sum of duplication string and prefix of the "string: "
     * if you enter "null", the method will fail.
     * @param message If the input parameters are duplicated, The <code>string: String (x2)</code> to be printed.
     */
    @Override
    public void log(String message) {
        if (factory.getState() == LoggerStateHolder.SIMPLE_PRINT){
            factory.setStringState();
            factory.loggerState.log(message);
        }else if (factory.getState() != LoggerStateHolder.STRING_REPEAITING ){
            factory.loggerState.flush();
            factory.setStringState();
            factory.loggerState.log(message);
        }else{
            factory.loggerState.log(message);
        }
    }

    /**
     * Concatenation of symbols and array elements
     * @param array print array
     */
    @Override
    public void log(int[] array) {
        factory.setSimplePrintState();
        factory.loggerState.log(array);
    }

    /**
     * Concatenation of symbols and array elements
     * @param matrix print the array in the array
     */
    @Override
    public void log(int[][] matrix) {
        factory.setSimplePrintState();
        factory.loggerState.log(matrix);
    }

    /**
     * Concatenation of symbols and array element
     * @param multiMatrix print miltiMatrix
     */
    @Override
    public void log(int[][][][] multiMatrix) {
        factory.setSimplePrintState();
        factory.loggerState.log(multiMatrix);
    }

    /**
     * Print list of arguments type String
     * @param elements The <code>String...</code> to be printed.
     */
    @Override
    public void log(String... elements) {
        factory.setSimplePrintState();
        factory.loggerState.log(elements);
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() {
        factory.loggerState.flush();
    }
    //endregion
}
