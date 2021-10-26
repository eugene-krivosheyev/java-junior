package com.acme.edu.message;

public class ByteMessage extends NumberMessage {

    private Integer value;

    public ByteMessage(Byte value) {
        this.value = (int) value;
    }

    public Integer getValue() {
        return value;
    }

    public void accumulate(Message message) {
        ByteMessage byteMessage = (ByteMessage) message;
        this.value += byteMessage.getValue();
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
    }
}
