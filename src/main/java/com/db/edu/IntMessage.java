package com.db.edu;

public class IntMessage {
    private int messageBody;
    int intCount = 0;

    void printAccumulatedInt() {
        if (intCount != 0) {
            ConsoleSaver.printToConsole(this.toString());
            intCount = 0;
            messageBody = 0;
        }
    }

    public IntMessage(int messageBody) {
        this.messageBody = messageBody;
    }

    public void accumulate(IntMessage message) {
        intCount++;
        messageBody += message.messageBody;
    }

    @Override
    public String toString() {
        return Prefix.PRIMITIVE.value + messageBody;
    }
}
