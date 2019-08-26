package com.acme.edu.commands;

import com.acme.edu.Logger.LoggingType;

public abstract class PrimitiveCommand implements Command {
    private static String PREFIX_PRIMITIVE = "primitive: ";
    private LoggingType type;

    public PrimitiveCommand(LoggingType type) {
        this.type = type;
    }


    @Override
    public LoggingType getType() {
        return type;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other.getType() == type;
    }

    @Override
    public abstract CommandAccumulateInfo accumulate(Command other);

    @Override
    public abstract Object getMessage();

    @Override
    public String getDecoratedMessage() {
        return PREFIX_PRIMITIVE + getMessage();
    }
}
