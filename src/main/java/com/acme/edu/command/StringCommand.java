package com.acme.edu.command;

import com.acme.edu.exception.BufferOverflowException;

/**
 * @see LoggerCommand
 */
public class StringCommand implements LoggerCommand {
    private int strCounter;
    private String value;
    final static String
            PREFIX_PRIMITIVE = "string: ";

    public StringCommand(String message) {
        strCounter = 1;
        this.value = message;
    }

    @Override
    public String getDecoratedSelf() {
        if (strCounter > 1)
            return PREFIX_PRIMITIVE + value + " (x" + strCounter + ")";
        return PREFIX_PRIMITIVE + value;
    }

    @Override
    public boolean checkFlush(LoggerCommand other) {
        if (other instanceof StringCommand)
            return !this.value.equals(((StringCommand) other).value);
        return true;
    }

    @Override
    public void accumulate(LoggerCommand other) throws BufferOverflowException{
        if ((long) strCounter < Integer.MAX_VALUE) {
            strCounter++;
        } else throw new BufferOverflowException();
    }
}
