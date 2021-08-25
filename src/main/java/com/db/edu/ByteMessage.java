package com.db.edu;

public class ByteMessage {
    private byte messageBody;

    public ByteMessage(byte messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.PRIMITIVE.value + messageBody;
    }

    public void printAccumulatedBytes(){
        ConsoleSaver.printToConsole(this.toString());
    }
}
