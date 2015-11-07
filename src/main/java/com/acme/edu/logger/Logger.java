package com.acme.edu.logger;

import com.acme.edu.printer.Printable;
import com.acme.edu.states.LoggerState;
import com.acme.edu.states.StateException;


/**
 * Class Log method overload
 * Type conversion
 *
 * @author Pavel Seregin
 * @version 1.1 2 Nov 2015
 */
public class Logger{

    //region fields
    private Factory factory;
    private LoggerState state = null;
    //endregion

    //region constructor
    /**
     * Setting the object Factory
     *
     * @param factory
     */
    public Logger(Factory factory, Printable... printables) {
        LoggerState.printers = printables;
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
    public void log(int message) throws LogException{
        if (state == null){
            state = factory.getIntState();
        }
        checkStateInt(message);
    }

    /**
     * Print the sum of consecutive integers and prefix of the "primitive: "
     * Print string and considers the sum of duplication string and prefix of the "string: "
     * if you enter "null", the method will fail.
     *
     * @param message If the input parameters are duplicated, The <code>string: String (x2)</code> to be printed.
     */
    public void log(String message) throws LogException{
        if (message == null || message.isEmpty()){
            throw new LogException(new IllegalArgumentException());
        }
        if (state == null){
            state = factory.getStringState();
        }
        checkStateString(message);
    }

    /**
     * Prints an boolean and prefix of the "primitive: "
     * @param message The <code>primitive: boolean</code> to be printed.
     */
    public void log(boolean message) throws LogException {
        try {
            state = factory.getUnBufferState();
            factory.getUnBufferState().log(LoggerState.PRIMITIVE + String.valueOf(message));
        } catch (StateException e) {
            throw new LogException(e);
        }
    }

    /**
     * Prints an char and prefix of the "char: "
     * @param message The <code>char: char</code> to be printed.
     */
    public void log(char message) throws LogException{
        try {
            state = factory.getUnBufferState();
            factory.getUnBufferState().log(LoggerState.CHAR + String.valueOf(message));
        } catch (StateException e) {
            throw new LogException(e);
        }
    }

    /**
     * Prints an Object and prefix of the "reference: "
     * @param message The <code>reference: Object</code> to be printed.
     */
    public void log(Object message) throws LogException {
        if (message == null){
            throw new LogException(new IllegalArgumentException());
        }
        try {
            state = factory.getUnBufferState();
            factory.getUnBufferState().log(LoggerState.REFERENCE + String.valueOf(message));
        } catch (StateException e) {
            throw new LogException(e);
        }
    }


    /**
     * Concatenation of symbols and array elements
     * @param matrix print the array in the array
     */
    public void log(int[][] matrix) throws LogException{
        if (matrix.length == 0){
            throw new LogException(new IllegalArgumentException());
        }
        for (int[] element : matrix) {
            log(element);
        }
    }

    /**
     * Concatenation of symbols and array element
     * @param multiMatrix print miltiMatrix
     */
    public void log(int[][][][] multiMatrix) throws LogException{
        if (multiMatrix.length == 0){
            throw new LogException(new IllegalArgumentException());
        }
        for (int[][][] firstLevel : multiMatrix) {
            for (int[][] secondLevel : firstLevel) {
                log(secondLevel);
            }
        }
    }

    /**
     * Print list of arguments type String
     * @param elements The <code>String...</code> to be printed.
     */
    public void log(String... elements) throws LogException{
        if (elements.length == 0){
            throw new LogException(new IllegalArgumentException());
        }
        for (String element : elements) {
            log(element);
        }
    }

    /**
     * Print list of arguments type Integer
     * @param elements The <code>Integer...</code> to be printed.
     */
    public void log(int... elements) throws LogException{
        if (elements.length == 0){
            throw new LogException(new IllegalArgumentException());
        }
        for (int element : elements) {
            log(element);
        }
    }

    /**
     * Clearing buffers
     */
    public void flush() throws LogException {
        try {
            state.flush();
        }catch (StateException e){
            throw new LogException(e);
        }
    }

    private void checkStateInt(int message) throws LogException {
        try {
            if (state != factory.getIntState()) {
                state.flush();
                state = factory.getIntState();
                state.log(String.valueOf(message));
            } else {
                state.log(String.valueOf(message));
            }
        } catch (StateException e) {
            throw new LogException(e);
        }
    }

    private void checkStateString(String message) throws LogException {
        try {
            if (state != factory.getStringState()) {
                state.flush();
                state = factory.getStringState();
                state.log(message);
            } else {
                state.log(message);
            }
        } catch (StateException e) {
            throw new LogException(e);
        }
    }
    //endregion
}
