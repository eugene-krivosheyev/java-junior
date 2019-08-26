package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.MATRIX;

public class MatrixDecorateCommand implements DecorateCommand, Decorate {
    private int[][] message;

    public MatrixDecorateCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return MATRIX.getType() + Decorate.decorateArray2D(message)
                .replace("[", "{")
                .replace("]", "}");
    }
}
