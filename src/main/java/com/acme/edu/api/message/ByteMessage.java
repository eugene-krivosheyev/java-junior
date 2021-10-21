package com.acme.edu.api.message;

public class ByteMessage extends Message {
    private final long byteValue;
    private String overflows = "";

    public ByteMessage(byte value) {
        byteValue = value;
        setPrefix("primitive: ");
        setValue(String.valueOf(value));
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public String getMessageAsString() {
        return overflows + super.getMessageAsString();
    }

    @Override
    public Message accumulate(Message message) {
        ByteMessage integerMessage = (ByteMessage) message;
        ByteMessage result = new ByteMessage((byte) handleOverflows(integerMessage.getByteValue()));
        result.setOverflows(overflows);
        return result;
    }

    public byte getByteValue() {
        return (byte) byteValue;
    }

    protected void setOverflows(String overflows) {
        this.overflows = overflows;
    }

    private long handleOverflows(int add) {
        long result = byteValue + add;
        if (result > Byte.MAX_VALUE) {
            setOverflows(Byte.MAX_VALUE + System.lineSeparator());
            result -= Byte.MAX_VALUE;
        } else if (result < Byte.MIN_VALUE) {
            setOverflows(Byte.MIN_VALUE + System.lineSeparator());
            result -= Byte.MIN_VALUE;
        }
        return result;
    }
}
