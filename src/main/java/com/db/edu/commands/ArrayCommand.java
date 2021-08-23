package com.db.edu.commands;

import java.util.Arrays;

import static com.db.edu.Prefixes.PRIMITIVE_ARRAY_PREFIX;

public class ArrayCommand extends Command {

    private int[] message;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    public Command accumulate(Command another) {
        finishCommand();
        return another;
    }

    public void finishCommand() {
        builder.append(PRIMITIVE_ARRAY_PREFIX)
                .append(Arrays.toString(message).replace('[', '{').replace(']', '}'))
                .append(System.lineSeparator());
    }

}
