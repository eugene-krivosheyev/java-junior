package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.MATRIX;

public class MatrixCommand implements DecorateCommand {
    private int[][] message;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        DecorateArray decorateArray = new DecorateMatrix();
        return MATRIX.getType() + decorateArray.decorate(message);
    }
}
