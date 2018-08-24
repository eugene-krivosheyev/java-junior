package com.acme.edu.message;

public class ByteMessage implements Message {
    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        ByteMessage downcastedMessage =  (ByteMessage)nextMessage;
        return new ByteMessage((byte)(this.message + downcastedMessage.message));
    }

    @Override
    public String getDecoratedMessage() {
        return String.format("%s: %d%s", "primitive", message, System.lineSeparator());
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }
}
