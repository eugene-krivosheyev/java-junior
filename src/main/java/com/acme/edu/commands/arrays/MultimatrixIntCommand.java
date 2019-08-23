package com.acme.edu.commands.arrays;

public class MultimatrixIntCommand extends ArrayCommand {
    private int[][][][] message;

    public MultimatrixIntCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.decorateArray(message);
    }


    @Override
    public String getMessage() { return String.valueOf(message); }
}
