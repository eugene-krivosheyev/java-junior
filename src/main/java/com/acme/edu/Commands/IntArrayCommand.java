package com.acme.edu.Commands;

import com.acme.edu.Logger.LoggingType;

public class IntArrayCommand implements Command {
    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";

    private int[] message;
    private LoggingType type;



    public IntArrayCommand(int[] message) {
        this.message = message;
        type = LoggingType.INTARRAY;
    }

    public String flush() {
        if(type == LoggingType.INTARRAY) {
            return getDecoratedMessage();
        }
        return "";
    }


    private String intArrayToString() {
        String res = "{";
        for(int i = 0; i < message.length; ++i) {
            res += Integer.toString(message[i]);
            if (i < message.length - 1) {
                res += ", ";
            }
        }
        return res + "}";
    }

    public LoggingType getType() {
        return type;
    }

    public boolean isTypeEquals(Command other) {
        //return other instanceof IntArrayCommand;
        return other instanceof IntArrayCommand && other.getType() == type;
    }
    public CommandAccumulateInfo accumulate(Command other) {
        return new CommandAccumulateInfo(other, null, 0);
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        return PREFIX_PRIMITIVES_ARRAY + intArrayToString();
    }
}
