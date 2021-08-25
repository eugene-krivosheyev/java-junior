package com.db.edu;

public class IntMessage {
    private int messageBody;

    static int intSum = 0;
    static int intCount = 0;

    static void printAccumulatedInt() {
        if (intCount != 0) {
            ConsoleSaver.printToConsole(Prefix.PRIMITIVE.value + intSum);
            intCount = 0;
            intSum = 0;
        }
    }

    public IntMessage(int messageBody) {
        this.messageBody = messageBody;
    }

    static public void accumulate(IntMessage message) {
        intCount++;
        intSum += message.messageBody;
    }

    @Override
    public String toString() {
        return Prefix.PRIMITIVE.value + messageBody;
    }
}
