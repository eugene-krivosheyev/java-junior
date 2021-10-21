package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class CharMessage implements Message {


    private char value;

    public CharMessage(char value) {
        this.value = value;
    }


    @Override
    public String getDecoratedString() {
        return "char: " + value;
    }

    @Override
    public boolean isSameType(Message message) {
        return (message instanceof CharMessage);
    }

    @Override
    public void accumulate(Message message, Printer printer) {
        printer.print(this);

    }
}
