package com.acme.edu.comands;

import com.acme.edu.Decorate;

import static com.acme.edu.LoggerType.MATRIX;

public class MatrixCommand implements Command, Decorate {
    private int[][] message;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return MATRIX.getType() + Decorate.decorateArray2D(message)
                .replace("[", "{")
                .replace("]", "}");
    }
}
