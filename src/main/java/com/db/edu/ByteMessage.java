package com.db.edu;

public class ByteMessage implements Message {
    private byte messageBody;

    public ByteMessage(byte messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.PRIMITIVE.value + messageBody;
    }

    @Override
    public void accumulate(Message message) {

    }

    @Override
    public void printAccumulated() {
        ConsoleSaver.printToConsole(this.toString());
    }
}
