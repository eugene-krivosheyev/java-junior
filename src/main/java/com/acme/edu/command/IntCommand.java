package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class IntCommand implements Command {
    private int message = 0;
    private Type CURRENT_TYPE = Type.INT;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public boolean accumulate(Command command) {
        if (isAccumulative(command)) {
            int commandValue = ((IntCommand)command).getIntValue();
            setIntValue(commandValue+message);
            return true;
        } else {
            return false;
        }
    }

    private boolean isAccumulative(Command command) {
        if (command.getType().equals(CURRENT_TYPE)) {
            int intBuff = ((IntCommand) command).getIntValue();
            if (intBuff > 0 && (Integer.MAX_VALUE - intBuff < message)) return false;
            if (intBuff <= 0 && (Integer.MIN_VALUE - intBuff > message)) return false;
            return true;
        }
        return false;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() { return String.valueOf(message);
    }

    public int getIntValue() {
        return message;
    }

    public void setIntValue(int value) {
        message = value;
    }

}
