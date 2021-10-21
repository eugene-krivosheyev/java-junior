package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

// TODO make more common NumberMessage class with getNumber method and overflow logic
public class IntMessage implements Message {

    private int value;

    public IntMessage(int message) {
        value = message;
    }

    @Override
    public String getDecoratedString() {
        return "primitive: " + value;
    }

    @Override
    public boolean isSameType(Message message) {
        return (message instanceof IntMessage);
    }

    /*
    state.setNextType(Type.INTEGER);
        if (processPreviousMessage()) {
            intMessage.setValue(message);
        } else {
            if (intMessage.getValue() + (long)message > Integer.MAX_VALUE) {
                // TODO fix overflow logic
                printer.print(intMessage);
                intMessage.setValue(Integer.MAX_VALUE);
                printer.print(intMessage);
            }
            intMessage.setValue(intMessage.getValue() + message);
        }
    * */

    @Override
    public void accumulate(Message message, Printer printer) {
        if (!(message instanceof IntMessage)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of IntMessage");
        }
        IntMessage newMessage = (IntMessage) message;
        if (value + (long) newMessage.value > Integer.MAX_VALUE) {
            // TODO fix overflow logic
            printer.print(this);
            value = Integer.MAX_VALUE;
            printer.print(this);
        }
        value += newMessage.value;
    }

}
