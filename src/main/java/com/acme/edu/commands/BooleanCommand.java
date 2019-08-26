package com.acme.edu.commands;

import com.acme.edu.Logger.LoggingType;

import java.io.PrintWriter;

public class BooleanCommand extends PrimitiveCommand {
    boolean message;

    public BooleanCommand(boolean message) {
        super(LoggingType.BOOLEAN);
        this.message = message;
    }

    @Override
    public CommandAccumulateInfo accumulate(Command other) {
        return new CommandAccumulateInfo(this, other.getDecoratedMessage(), 0);
    }

    @Override
    public Object getMessage() {
        return message;
    }


}
