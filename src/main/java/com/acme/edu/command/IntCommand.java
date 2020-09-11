package com.acme.edu.command;

/**
 * @see LoggerCommand
 */

public class IntCommand implements LoggerCommand {
    private int value;
    final static String PREFIX_PRIMITIVE = "primitive: ";

    public IntCommand(int message) {
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
            if (sumCheck >= Integer.MAX_VALUE) throw new BufferOverflowException();
            return sumCheck >= Integer.MAX_VALUE;
        }
        return true;
    }

    @Override
    public void accumulate(LoggerCommand other) throws BufferOverflowException{
        if ((long)  this.value < Integer.MAX_VALUE)
            this.value += ((IntCommand)other).value;
        else throw new BufferOverflowException();
    }
}
