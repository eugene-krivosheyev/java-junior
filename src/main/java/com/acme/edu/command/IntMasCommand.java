package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class IntMasCommand {
    private int[] message = {1};
    private Type CURRENT_TYPE = Type.INT_MAS;

    public IntMasCommand(int[] message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(int value) {
        String str= "primitives array: {";
        for(int i:message)
            str+=i+", ";
        str=str.substring(0,str.length()-2)+"}";
        return str;
    }

    public int[] getIntMasValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        return true;
    }
}
