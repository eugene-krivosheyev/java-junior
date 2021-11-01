package com.acme.edu.api.message;

public class ByteMessage extends SummableMessage {
    public ByteMessage(byte value) {
        setCurrentSum(value);
        setPrefix("primitive: ");
        setValue(String.valueOf(value));
        setMax(Byte.MAX_VALUE);
        setMin(Byte.MIN_VALUE);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    protected SummableMessage getNewMessageOfMyType(long value) {
        return new ByteMessage((byte) value);
    }
}
