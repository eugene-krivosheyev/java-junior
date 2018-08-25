package com.acme.edu.message;

public class ByteMessage implements Message {
    private static final String PRIMITIVE = "primitive: ";
    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    public boolean isSameTypeOf(Message comparedMessage){
        return  (comparedMessage instanceof ByteMessage);
    }

    @Override
    public String getDecoratedMessage() {
        return PRIMITIVE + this.message;
    }

    @Override
    public Message accumulate(Message message) {
        ByteMessage byteMessage = (ByteMessage) message;
        this.message += byteMessage.message;
        return this;
    }
}
