package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class MatrixMessage extends Message {
    private final int[][] message;

    public MatrixMessage(int[][] message) {
        typeCodeEnum = TypeCodeEnum.MATRIX_INT;
        this.message = message;
    }

    public int[][] getMessage() {
        return message;
    }
}
