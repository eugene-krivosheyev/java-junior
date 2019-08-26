package com.acme.edu.commands;

public class MatrixCommand implements DecorateCommand {
    private int[][] message;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        DecorateArray decorateArray = new MatrixDecorator();
        return "primitives matrix: " + decorateArray.decorate(message);
    }
}
