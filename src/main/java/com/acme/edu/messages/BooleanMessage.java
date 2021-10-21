package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class BooleanMessage implements Message {


    private boolean value;

    public BooleanMessage(boolean value) {
        this.value = value;
    }

    @Override
    public String getDecoratedString() {
        return "boolean: " + value;
    }


    @Override
    public boolean isSameType(Message message) {
        return (message instanceof BooleanMessage);
    }

    @Override
    public void accumulate(Message message, Printer printer) {
        printer.print(this);
    }
}
