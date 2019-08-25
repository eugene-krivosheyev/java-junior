package com.acme.edu.Commands;

import com.acme.edu.Logger;

public class ByteCommand implements Command{
    private static String PREFIX_PRIMITIVE = "primitive: ";

    private byte message;
    private Logger.LoggingType type;


    public ByteCommand(byte message) {
        this.message = message;
        type = Logger.LoggingType.BYTE;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public String flush() {
        byte tmp_message = message;
        message = 0;
        return PREFIX_PRIMITIVE + tmp_message;
    }

    @Override
    public Logger.LoggingType getType() {
        return type;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand && other.getType() == type;
    }

    @Override
    public CommandAccumulateInfo accumulate(Command other) {
        if (other == null) return new CommandAccumulateInfo(this, null, -1);
        if (! (other instanceof ByteCommand)) return new CommandAccumulateInfo(other, null, -1);
        String returnMessage = null;
        int otherMessage = (Byte)(other.getMessage());
        long sum = (long)message + otherMessage;
        if(Byte.MIN_VALUE > sum || sum > Byte.MAX_VALUE) {
            returnMessage = PREFIX_PRIMITIVE + message;
            sum = otherMessage;
        }

        return new CommandAccumulateInfo(this, returnMessage, 0);
    }
}
