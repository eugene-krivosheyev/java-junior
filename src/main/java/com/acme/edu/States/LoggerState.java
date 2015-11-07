package com.acme.edu.states;

import com.acme.edu.logger.LogException;

/**
 * Contains prefix and behavior of logger
 */
public interface LoggerState{

    //region constants
    String CHAR = "char: ";
    String STRING = "string: ";
    String REFERENCE = "reference: ";
    String PRIMITIVE = "primitive: ";
    String SEP = System.lineSeparator();
    //endregion

    /**
     * Print message
     * @param message
     */
    void log(String message) throws StateException, LogException;

    /**
     * Clearing buffers
     */
    void flush() throws StateException, LogException;
}