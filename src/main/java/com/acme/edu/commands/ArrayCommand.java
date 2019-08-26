package com.acme.edu.commands;

import com.acme.edu.Constants;

import java.util.Arrays;

public class ArrayCommand implements Command {
    private final int[] message;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.ARRAY_PREFIX + arrayToString(message);
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof ArrayCommand;
    }

    @Override
    public void accumulate(Command command) {
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return true;
    }

    static String arrayToString(int[] array) {
        return Arrays.toString(array)
                .replace("[", "{")
                .replace("]", "}");
    }
}
