package com.acme.edu.Commands;

import com.acme.edu.Logger;
import com.acme.edu.Logger.LoggingType;

public class StringCommand implements Command {
    private static String PREFIX_STRING = "string: ";

    private String message;
    private LoggingType type;

    public StringCommand(String message) {
        this.message = message;
        this.type = LoggingType.STRING;
    }




    @Override
    public String flush() {
        return PREFIX_STRING + message;
    }

    @Override
    public LoggingType getType() {
        return type;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof StringCommand && this.type == other.getType();
    }

    @Override
    public CommandAccumulateInfo accumulate(Command other) {
        if (other == null) return new CommandAccumulateInfo(this, null, -1);
        if (! (other instanceof StringCommand)) return new CommandAccumulateInfo(other, null, -1);
        String returnMessage = (String) this.getMessage();


        return new CommandAccumulateInfo(other, returnMessage, 0);
    }

    @Override
    public Object getMessage() {
        return null;
    }
}
