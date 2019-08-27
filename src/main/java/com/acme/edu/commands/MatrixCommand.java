package com.acme.edu.commands;


import com.acme.edu.Constants;

public class MatrixCommand implements Command {
    private final int[][] message;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.MATRIX_PREFIX + arrayToString(message);
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof MatrixCommand;
    }

    @Override
    public MatrixCommand accumulate(Command command) {
        return this;
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return true;
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
