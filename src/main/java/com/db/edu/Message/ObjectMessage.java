package com.db.edu.Message;

import com.db.edu.ConsoleSaver;
import com.db.edu.Message.Message;
import com.db.edu.Prefix;

public class ObjectMessage implements Message {
    private Object messageBody;

    public ObjectMessage(Object messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return Prefix.REFERENCE.value + messageBody;
    }

    @Override
    public void accumulate(Message message) {
    }

    @Override
    public void printAccumulated() {
        ConsoleSaver.printToConsole(this.toString());
    }
}
