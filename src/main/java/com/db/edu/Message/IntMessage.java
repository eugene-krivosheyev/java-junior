package com.db.edu.Message;

import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Prefix;

public class IntMessage implements Message {
    private int messageBody;

    public void close() {
            messageBody = 0;
    }

    public IntMessage(int messageBody) {
        this.messageBody = messageBody;
    }

    public void accumulate(Message message) throws ClassCastException {
        try {
            messageBody += ((IntMessage)message).messageBody;
        } catch (ClassCastException e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public String decorate() {
        return Prefix.PRIMITIVE.value + messageBody;
    }

    @Override
    public String getValue() {
        return String.valueOf(messageBody);
    }
}
