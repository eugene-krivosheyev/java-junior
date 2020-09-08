package com.acme.edu.command;

import com.acme.edu.message.Type;

public class IntCommand extends LoggerCommand{
    protected int intAccumulator = 0;
    private final String INT = "int";

    public IntCommand(int message) {
        intAccumulator = message;
        decorate(message);
    }

    @Override
    public boolean isSameType(LoggerCommand loggerCommand) {
        return loggerCommand instanceof IntCommand;
    }

    @Override
    public LoggerCommand accumulate(LoggerCommand loggerCommand) {
        if (loggerCommand instanceof IntCommand) {
            final IntCommand intCommand = (IntCommand) loggerCommand;
            return new IntCommand(intAccumulator + intCommand.intAccumulator);
        }
        return new IntCommand(intAccumulator + loggerCommand.intAccumulator);
    }

    private void decorate(int message){
        int diff = checkNumberAccumulatorOverflow(Integer.MAX_VALUE, intAccumulator, message);
        if (Integer.MAX_VALUE - intAccumulator < message) {
            intAccumulator += diff;
            message -= diff;
            flush();
        }
        intAccumulator += message;
        if (previousType != null && !previousType.equals(Type.INT)) {
            flush();
        }
    }

    @Override
    public String clearBuffer() {
        String buffer = Integer.toString(intAccumulator);
        intAccumulator = 0;
        return buffer;
    }
}
