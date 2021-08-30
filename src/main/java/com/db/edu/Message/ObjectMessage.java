package com.db.edu.Message;

import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Prefix;

public class ObjectMessage implements Message {
    private Object messageBody;

    public ObjectMessage(Object messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String decorate() {
        return Prefix.REFERENCE.value + messageBody;
    }

    @Override
    public String getValue() {
        return messageBody.toString();
    }

    @Override
    public void accumulate(Message message) {
    }

    @Override
    public void close() {
    }
}
