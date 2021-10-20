package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class StringMessage implements Message {
    public void setValue(String value) {
        this.value = value;
    }

    private String value;
    private int counter;

    public StringMessage(String value) {
        this.value = value;
        counter = 1;
    }
    @Override
    public String getDecoratedString() {
        if (counter > 1) {
            return "string: " + value + " (x" + counter + ")";
        } else {
            return "string: " + value;
        }
    }

    @Override
    public void clear() {
        value = "";
        counter = 1;
    }

    public void process(Printer printer, String newValue) {
        if (value.equals(newValue)) {
            counter++;
        } else {
            printer.print(this);
            value = newValue;
            counter = 1;
        }
    }


}
