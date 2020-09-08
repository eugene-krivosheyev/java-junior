package com.acme.edu.message;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.utils.Saver;

public class ByteMessage extends LoggerMessage{
    private byte message;

    private byte maxByteValueAmount = 0; // overflow
    private byte currentByteMessage = 0; // sum int

    public ByteMessage(byte message) {
        super(MessageType.BYTE, MessagePrefix.PRIMITIVE_PREFIX);
        this.message = message;
    }

    @Override
    public void accumulateMessage(LoggerMessage byteMessage) {
        int result = (int) ((ByteMessage) byteMessage).getMessage() + (int) currentByteMessage;
        if (result > Byte.MAX_VALUE) {
            currentByteMessage = (byte) (result - Byte.MAX_VALUE);
            maxByteValueAmount++;
        } else {
            currentByteMessage = (byte) result;
        }
    }

    @Override
    public String createMessageWithPrefix() {
        return referencePrefix.getPrefixString() + currentByteMessage;
    }

    private String createMessageWithOverflow() {
        return referencePrefix.getPrefixString() + Byte.MAX_VALUE;
    }

    @Override
    public boolean isSameType(LoggerMessage message) {
        return message instanceof ByteMessage;
    }

    @Override
    public void printMessageBuffer(Saver saver) {
        saver.print(this.createMessageWithPrefix());
        for (int i = 0; i < maxByteValueAmount; i++) {
            saver.print(this.createMessageWithOverflow());
        }
        this.currentByteMessage = 0;
        this.maxByteValueAmount = 0;
    }

    public byte getMessage() {
        return message;
    }
}
