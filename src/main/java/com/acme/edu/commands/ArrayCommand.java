package com.acme.edu.commands;

import java.util.Arrays;

public class ArrayCommand implements DecorateCommand {
    private int[] message;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        String finalMessage = Arrays.toString(message);
        return "primitives array: " + finalMessage
                .replace("[", "{")
                .replace("]", "}");
    }
}
