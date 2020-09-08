package com.acme.edu.command;

import com.acme.edu.message.Prefix;

public class IntCommand implements LoggerCommand {
    private int intAccumulator = 0;

    public IntCommand(int message) {
        intAccumulator = message;
    }

    @Override
    public String toString() {
        return Prefix.PRIMITIVE.getValue() + Integer.toString(intAccumulator);
    }

    @Override
    public boolean isSameType(LoggerCommand loggerCommand) {
        return loggerCommand instanceof IntCommand;
    }

    @Override
    public LoggerCommand accumulate(LoggerCommand loggerCommand) {
        return new IntCommand(intAccumulator + ((IntCommand) loggerCommand).intAccumulator);
    }
}
