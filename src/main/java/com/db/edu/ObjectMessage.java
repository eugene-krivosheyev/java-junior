package com.db.edu;

public class ObjectMessage {
    private Object messageBody;

    public ObjectMessage(Object messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.REFERENCE.value + messageBody;
    }

    public void printAccumulatedObject(){
        ConsoleSaver.printToConsole(this.toString());
    }
}
