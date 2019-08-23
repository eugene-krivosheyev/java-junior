package com.acme.edu.commands.arrays;


public class MatrixIntArrayCommand extends ArrayCommand {
    private int[][] message;

    public MatrixIntArrayCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.decorateArray(message);
    }


    @Override
    public String getMessage() { return String.valueOf(message); }
}
