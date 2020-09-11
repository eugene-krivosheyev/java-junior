package com.acme.edu.command;

import com.acme.edu.exception.IntLogException;
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
    public LoggerCommand accumulate(LoggerCommand loggerCommand) throws IntLogException {
        if (Integer.MAX_VALUE - intAccumulator < ((IntCommand) loggerCommand).intAccumulator) {
            throw new IntLogException("can't accumulate integer cause by overflow");
        }
        return new IntCommand(intAccumulator + ((IntCommand) loggerCommand).intAccumulator);
    }
}
