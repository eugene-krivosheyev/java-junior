package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class ByteMessage implements Message {
    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    private byte value;

    public ByteMessage(byte message) {
        value = message;
    }
    @Override
    public String getDecoratedString() {
        return "primitive: " + value;
    }

    @Override
    public void clear() {
        value = 0;
    }

    @Override
    public boolean isSameType(Message message) {
        return (message instanceof ByteMessage);
    }

    @Override
    public void accumulate(Message message, Printer printer) {
        if (!(message instanceof ByteMessage)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of ByteMessage");
        }
        ByteMessage newMessage = (ByteMessage) message;
        if (value + (int)newMessage.value > Byte.MAX_VALUE) {
            // TODO fix overflow logic
            printer.print(this);
            value = Byte.MAX_VALUE;
            printer.print(this);
        }
        value += newMessage.value;
    }
}
