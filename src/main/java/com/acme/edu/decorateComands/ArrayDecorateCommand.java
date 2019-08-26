package com.acme.edu.decorateComands;

import java.util.Arrays;

import static com.acme.edu.LoggerType.ARRAY;

public class ArrayDecorateCommand implements DecorateCommand {
    private int[] message;

    public ArrayDecorateCommand(int[] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        String finalMessage = Arrays.toString(message);
        return ARRAY.getType() + finalMessage
                .replace("[", "{")
                .replace("]", "}");
    }
}
