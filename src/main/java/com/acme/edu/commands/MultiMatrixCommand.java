package com.acme.edu.commands;


import com.acme.edu.Constants;

import java.util.Arrays;

public class MultiMatrixCommand implements Command {
    private final int[][][][] message;

    public MultiMatrixCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.MULTIMATRIX_PREFIX + arrayToString(message);
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof MultiMatrixCommand;
    }

    @Override
    public MultiMatrixCommand accumulate(Command command) {
        return this;
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return true;
    }

    static String arrayToString(int[][][][] array) {
        return Arrays.deepToString(array)
                .replace("[", "{\n")
                .replace("]", "}\n");
    }
}

