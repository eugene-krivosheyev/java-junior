package com.db.edu.Message;

import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Prefix;

public class ByteMessage implements Message {
    private byte messageBody;

    public ByteMessage(byte messageBody) {
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
