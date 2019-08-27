package com.acme.edu.commands;

import com.acme.edu.ArraysFormatter;

public class ArrayCommand implements Command {
    private final int[] value;

    public ArrayCommand(int[] value) {
        this.value = value;
    }

    @Override
    public String decorate() {
        return "primitives array: " + ArraysFormatter.convertArrayToString(value);
    }
}
