package com.acme.edu.commands.arrays;

public class ArrayIntCommand extends ArrayCommand {
    private int[] message;

    public ArrayIntCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.decorateArray(message);
    }


    @Override
    public String getMessage() { return String.valueOf(message); }
}
