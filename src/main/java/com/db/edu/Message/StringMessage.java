package com.db.edu.Message;

import com.db.edu.Prefix;

public class StringMessage implements Message {
    private String messageBody;
    int stringCount = 1;

    public StringMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String decorate() {
        return Prefix.STRING.value + messageBody + (stringCount > 1 ? " (x" + stringCount + ")" : "");
    }

    @Override
    public void accumulate(Message message) {
        if (stringCount > 0 && !messageBody.equals(((StringMessage)message).messageBody)) {
            this.close();
        }
        messageBody = ((StringMessage)message).messageBody;
        stringCount++;
    }

    @Override
    public void close() {
        stringCount = 0;
        messageBody = "";
    }
}
