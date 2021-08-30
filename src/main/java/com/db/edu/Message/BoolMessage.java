package com.db.edu.Message;

import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Prefix;

public class BoolMessage implements Message {
    private boolean messageBody;

    public BoolMessage(boolean messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String decorate() {
        return Prefix.PRIMITIVE.value + messageBody;
    }

    @Override
    public String getValue() {
        return String.valueOf(messageBody);
    }

    @Override
    public void accumulate(Message message) {
    }

    @Override
    public void close() {
    }
}
