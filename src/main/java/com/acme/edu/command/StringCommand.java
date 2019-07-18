package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class StringCommand implements Command {
    private String message = "";
    private int count = 1;
    private Type CURRENT_TYPE = Type.STRING;

    public StringCommand(String message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() {
        if (count > 1) {
            return message + " (x" + count + ")";
        } else {
            return message;
        }
    }

    public String getStringValue() {
        return message;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean accumulate(Command command) {
        if (isAccumulative(command)) {
            count = ((StringCommand) command).getCount() + 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean isAccumulative(Command command) {
        if (command.getType().equals(CURRENT_TYPE)) {
            return (message.equals(((StringCommand) command).getStringValue()));
        } else {
            return false;
        }
    }

    /*public boolean isOverflow(Accumulator accumulator) {
        return !message.equals(accumulator.getStrBuff());
    }*/
}
