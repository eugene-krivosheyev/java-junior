package com.acme.edu.comands;

import java.util.Arrays;

import static com.acme.edu.LoggerType.ARRAY;

public class ArrayCommand implements Command {
    private int[] message;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        String finalMessage = Arrays.toString(message);
        return ARRAY.getType() + finalMessage.replace("[", "{").replace("]", "}");
    }
}
