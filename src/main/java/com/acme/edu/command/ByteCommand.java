package com.acme.edu.command;

import com.acme.edu.Type;

public class ByteCommand implements Command {
    private byte message = 0;
    private Type CURRENT_TYPE = Type.BYTE;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public boolean accumulate(Command command) {
        if (isAccumulative(command)) {
            byte commandValue = ((ByteCommand)command).getByteValue();
            setByteValue((byte)(commandValue+message));
            return true;
        } else {
            return false;
        }
    }

    private boolean isAccumulative(Command command) {
        if (command.getType().equals(CURRENT_TYPE)) {
            byte byteBuff = ((ByteCommand) command).getByteValue();
            if (byteBuff > 0 && (Byte.MAX_VALUE - byteBuff < message)) return false;
            if (byteBuff <= 0 && (Byte.MIN_VALUE - byteBuff > message)) return false;
            return true;
        }
        return false;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() { return String.valueOf(message);
    }

    public byte getByteValue() {
        return message;
    }

    public void setByteValue(byte value) {
        message = value;
    }
}
