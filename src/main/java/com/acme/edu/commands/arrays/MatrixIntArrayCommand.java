package com.acme.edu.commands.arrays;


import com.acme.edu.StateCommand;
import com.acme.edu.commands.Command;

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
    public Command<String> accumulate(Command command) {
        return null;
    }

    @Override
    public String getMessage() { return String.valueOf(message); }

    @Override
    public StateCommand getState() { return StateCommand.NONE; }
}
