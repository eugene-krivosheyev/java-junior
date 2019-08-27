package com.acme.edu.commands;

import com.acme.edu.CommandAndFlushOptional;

/**
 * Created by kate-c on 25/08/2019.
 */
public class IntArrayCommand implements Command {
    private int[] messageArray;
    private static final String DELIMETER = ", ";

    public IntArrayCommand(int[] messageArray) {
        this.messageArray = messageArray;
    }

    public Object getMessage() {
        return messageArray;
    }

    @Override
    public void setMessage(Object message) {
        this.messageArray = (int[]) message;
    }

    @Override
    public String decorate() {
        return "primitives array: " + convertArrayToString(messageArray);
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof IntArrayCommand;
    }

    @Override
    public CommandAndFlushOptional accumulate(Command command) {
        throw new UnsupportedOperationException("Integer arrays can't be accumulated!");
    }

    private static String convertArrayToString(int[] array) {
        String temp = "{";
        for (int i = 0; i < array.length - 1; i++) {
            temp += array[i] + DELIMETER;
        }
        temp += array[array.length - 1] + "}";
        return temp;

    }
}
