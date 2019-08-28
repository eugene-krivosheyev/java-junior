package com.acme.edu.commands.arrays;

import com.acme.edu.StateCommand;
import com.acme.edu.commands.Command;

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
    public Command<String> accumulate(Command command) {
        try {
            if (!(command instanceof MultimatrixIntCommand))
                throw new IllegalArgumentException("Not a multimatrix int command!");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return new MultimatrixIntCommand(message);
    }

    @Override
    public String getMessage() { return String.valueOf(message); }

    @Override
    public StateCommand getState() { return StateCommand.NONE; }
}
