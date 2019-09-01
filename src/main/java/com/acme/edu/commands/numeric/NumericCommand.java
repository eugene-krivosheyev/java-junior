package com.acme.edu.commands.numeric;

import com.acme.edu.commands.AccumulableCommand;

public abstract class NumericCommand implements AccumulableCommand {
    public static final String PRIMITIVE_PREFIX = "primitive: ";

    long message;

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + message;
    }

    long getMessage() {
        return message;
    }
}
