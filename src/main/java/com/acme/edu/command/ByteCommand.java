package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class ByteCommand {
    private byte message = 0;
    private Type CURRENT_TYPE = Type.BYTE;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(byte value) {
        return String.valueOf(value);
    }

    public byte getByteValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        byte byteBuff = accumulator.getByteBuff();
        if (byteBuff > 0 && (Byte.MAX_VALUE - byteBuff < message)) return true;
        if (byteBuff <= 0 && (Byte.MIN_VALUE - byteBuff > message)) return true;
        return false;
    }
}
