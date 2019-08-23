package com.acme.edu;


public class MatrixCommand implements Command {
    private final int[][] message;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.MATRIX_PREFIX + arrayToString(message);
    }

    private String arrayToString(int[][] array) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int[] subArray : array) {
            sb.append(ArrayCommand.arrayToString(subArray)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
