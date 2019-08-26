package com.acme.edu.commands.arrays;

import com.acme.edu.buffer.BufferState;
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
        return null;
    }

    @Override
    public String getMessage() { return String.valueOf(message); }

    @Override
    public BufferState getState() { return BufferState.NONE; }
}
