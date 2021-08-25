package com.db.edu;

public class CharMessage {
    private char messageBody;

    public CharMessage(char messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.CHAR.value + messageBody;
    }

    public void printAccumulatedChar(){
        ConsoleSaver.printToConsole(this.toString());
    }
}
