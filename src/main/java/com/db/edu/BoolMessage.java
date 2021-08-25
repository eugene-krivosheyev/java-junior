package com.db.edu;

public class BoolMessage {
    private boolean messageBody;

    public BoolMessage(boolean messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.PRIMITIVE.value + messageBody;
    }

    public void printAccumulatedBool(){
        ConsoleSaver.printToConsole(this.toString());
    }
}
