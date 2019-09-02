package com.acme.edu.commands.vector;

import com.acme.edu.commands.Command;

public class IntMatrixCommand implements Command {
    public static final String PR_MATRIX_PREFIX = "primitives matrix: ";

    private int[][] message;

    public IntMatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return PR_MATRIX_PREFIX + matrixToString(message);
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int[] array : matrix) {
            sb.append(IntArrayCommand.arrayToString(array)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
