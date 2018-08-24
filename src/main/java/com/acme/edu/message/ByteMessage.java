package com.acme.edu.message;

public class ByteMessage extends Message {
    private static final String TYPE_NAME = "primitive";
    private byte value;

    public ByteMessage(byte message) {
        this.value = message;
        type = TYPE_NAME;
    }


    @Override
    public Message accumulate(Message message) {
        ByteMessage newMessage = (ByteMessage) message;
        byte newValue = (byte) (value + newMessage.value);
        return new ByteMessage(newValue);
    }

    @Override
    public String getFormattedMessage() {
        return super.getFormattedString(String.valueOf(value));
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message) && !isOverflow(((ByteMessage) message).value);
    }

    private boolean isOverflow(byte term){
        return (term > 0 && value > Byte.MAX_VALUE - term) ||
                (term < 0 && value < Byte.MIN_VALUE - term);
    }
}
