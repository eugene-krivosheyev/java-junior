package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by kate-c on 25/08/2019.
 */
public class IntArrayCommand extends Command {
    private int[] messageArray;

    public IntArrayCommand(int[] messageArray) {
        this.messageArray = messageArray;
    }

    public Object getMessage() {
        return messageArray;
    }

    @Override
    public String decorate() {
        return "primitives array: " + Arrays.stream(messageArray)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "{", "}"));
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof IntArrayCommand;
    }

    @Override
    public Command accumulate(Command command, Saver saver) {
        throw new UnsupportedOperationException("Integer arrays can't be accumulated!");
    }
}
