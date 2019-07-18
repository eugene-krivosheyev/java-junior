package com.acme.edu;

public class IntCommand {
    private int message = 0;
    private Type CURRENT_TYPE = Type.INT;

    public IntCommand(int message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(int value) {
        return String.valueOf(value);
    }

    public int getIntValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        int intBuff = accumulator.getIntBuff();
        if (intBuff > 0 && (Integer.MAX_VALUE - intBuff < message)) return true;
        if (intBuff <= 0 && (Integer.MIN_VALUE - intBuff > message)) return true;
        return false;
    }
}
