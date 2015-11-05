package com.acme.edu;

/**
 * Contains prefix and behavior of logger
 */
public interface LoggerState{

    //region constants
    String CHAR = "char: ";
    String STRING = "string: ";
    String REFERENCE = "reference: ";
    String PRIMITIVE = "primitive: ";
    String PRIMITIVES_ARRAY = "primitives array: ";
    String PRIMITIVES_MATRIX = "primitives matrix: ";
    String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: ";
    String SEP = System.lineSeparator();
    //endregion

    /**
     * Print message
     * @param message
     */
    void log(String message);

    /**
     * Clearing buffers
     */
    void flush();
    //endregion
}