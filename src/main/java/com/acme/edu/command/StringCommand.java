package com.acme.edu.command;

public class StringCommand extends LoggerCommand {
    private int strCounter;
    private String value;
    final static String
            PREFIX_PRIMITIVE = "string: ";

    public StringCommand (String message){
        strCounter = 1;
        this.value = message;
    }

    @Override
    public String getDecoratedSelf(){
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
    public void accumulate(LoggerCommand other) {
        strCounter++;
    }
}
