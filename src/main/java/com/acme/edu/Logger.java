package com.acme.edu;

import com.acme.edu.exceptions.*;
import com.acme.edu.exceptions.IllegalArgumentException;
import com.acme.edu.printer.Printer;
import com.acme.edu.states.LoggerState;
import com.acme.edu.states.StringState;

/**
 * Class Log method overload
 * Type conversion
 *
 * @author Pavel Seregin
 * @version 1.1 2 Nov 2015
 */
public class Logger implements LoggerState {

    //region fields
    Factory factory;
    private LoggerState state = new StringState(new Printer());
    //endregion

    //region constructor
    /**
     * Setting the object Factory
     * @param factory
     */
    public Logger(Factory factory) {
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
    public void log(int message) throws LogException, IllegalArgumentException {
        if (state != factory.getIntState()){
            state.flush();
            state  = factory.getIntState();
            state.log(String.valueOf(message));
        }else{
            state.log(String.valueOf(message));
        }
    }

    /**
     * Print the sum of consecutive integers and prefix of the "primitive: "
     * Print string and considers the sum of duplication string and prefix of the "string: "
     * if you enter "null", the method will fail.
     * @param message If the input parameters are duplicated, The <code>string: String (x2)</code> to be printed.
     */
    @Override
    public void log(String message) throws LogException, IllegalArgumentException {
        if (message == null || message.isEmpty()){
            throw new LogException(new IllegalArgumentException());
        }

        if (state != factory.getStringState()){
            state.flush();
            state  = factory.getStringState();
            state.log(message);
        }else{
            state.log(message);
        }
    }

    /**
     * Prints an boolean and prefix of the "primitive: "
     * @param message The <code>primitive: boolean</code> to be printed.
     */
    public void log(boolean message) throws LogException {
        factory.getUnBufferState().log(PRIMITIVE + String.valueOf(message));
    }

    /**
     * Prints an char and prefix of the "char: "
     * @param message The <code>char: char</code> to be printed.
     */
    public void log(char message) throws LogException {
        factory.getUnBufferState().log(CHAR + String.valueOf(message));
    }

    /**
     * Prints an Object and prefix of the "reference: "
     *
     * @param message The <code>reference: Object</code> to be printed.
     */
    public void log(Object message) throws LogException{
        if (message == null){
            throw new LogException( new IllegalArgumentException());
        }
        factory.getUnBufferState().log(REFERENCE + String.valueOf(message));
    }

    /**
     * Concatenation of symbols and array elements
     * @param array print array
     */
    public void log(int[] array) throws LogException {
        if (array == null){
            throw new LogException(new IllegalArgumentException());
        }
        factory.getUnBufferState().log(array);
    }

    /**
     * Concatenation of symbols and array elements
     * @param matrix print the array in the array
     */
    public void log(int[][] matrix) throws LogException {
        if (matrix == null){
            throw new LogException(new IllegalArgumentException());
        }
        factory.getUnBufferState().log(matrix);
    }

    /**
     * Concatenation of symbols and array element
     *
     * @param multiMatrix print miltiMatrix
     */
    public void log(int[][][][] multiMatrix) throws LogException {
        if (multiMatrix == null){
            throw new LogException(new IllegalArgumentException());
        }
        factory.getUnBufferState().log(multiMatrix);
    }

    /**
     * Print list of arguments type String
     *
     * @param elements The <code>String...</code> to be printed.
     */
    public void log(String... elements) throws LogException {
        if (elements.length == 0){
            throw new LogException(new IllegalArgumentException());
        }
        factory.getUnBufferState().log(elements);
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() throws LogException {
        state.flush();
    }
    //endregion
}
