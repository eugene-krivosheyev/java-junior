package com.db.edu;

public class CharMessage implements Message {
    private char messageBody;

    public CharMessage(char messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.CHAR.value + messageBody;
    }


    @Override
    public void accumulate(Message message) {

    }

    @Override
    public void printAccumulated() {
        ConsoleSaver.printToConsole(this.toString());
    }
}
