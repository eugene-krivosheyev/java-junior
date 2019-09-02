package com.acme.edu.commands.vector;

import com.acme.edu.commands.Command;

import java.util.Arrays;

public class IntArrayCommand implements Command {
    public static final String PR_ARRAY_PREFIX = "primitives array: ";

    private int[] message;

    public IntArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return PR_ARRAY_PREFIX
                + Arrays.toString(message)
                .replace("[", "{")
                .replace("]", "}");
    }
}
