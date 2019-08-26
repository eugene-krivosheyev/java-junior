package com.acme.edu.commands;

import com.acme.edu.ArraysFormatter;

public class MatrixCommand implements Command {
    private int[][] value;

    public MatrixCommand(int[][] value) {
        this.value = value;
    }

    @Override
    public String decorate() {
        return "primitives matrix: " + ArraysFormatter.convertMatrixToString(value);
    }
}
