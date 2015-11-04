package com.acme.edu;

interface LoggerState{

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

    //region operations
    void log(int[] array);
    void log(int[][] matrix);
    void log(int[][][][] multiMatrix);
    void log(String... elements);
    void log(String message);
    void flush();
    //endregion
}