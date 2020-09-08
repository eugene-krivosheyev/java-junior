package com.acme.edu.command;

public class IntCommand extends LoggerCommand {
    private int value;
    final static String
            PREFIX_PRIMITIVE = "primitive: ";

    public IntCommand (int message) {
        this.value = message;
    }

    @Override
    public String getDecoratedSelf() {
        return PREFIX_PRIMITIVE + value;
    }

    @Override
    public boolean checkFlush(LoggerCommand other) {
        if (other instanceof IntCommand) {
            long sumCheck = (long)((IntCommand) other).value + (long)this.value;
            return sumCheck >= Integer.MAX_VALUE;
        }
        return true;
    }

    @Override
    public void accumulate(LoggerCommand other) {
        this.value += ((IntCommand)other).value;
    }
}
