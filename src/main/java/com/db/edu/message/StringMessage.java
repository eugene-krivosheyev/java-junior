package com.db.edu.message;

import com.db.edu.Message;
import com.db.edu.Types;

public class StringMessage extends Message {
    private String body;
    private int stringCounter;

    public StringMessage(String message) {
        this.body = message;
    }

    public String getDecoratedMessage() {
        String resString = Types.PREFIX_STRING + ": " + body;
        if(stringCounter == 1) {
            return resString;
        }
        return resString + "(x" + stringCounter + ")";
    }

    public StringMessage accumulate(Message message) {
        StringMessage newMessage = (StringMessage)message;
        if (newMessage.equals(body)) {
            stringCounter++;
        } else {
            this.body = newMessage.body;
        }
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        StringMessage newMessage = (StringMessage)message;
        return (this.getState() == newMessage.getState() && newMessage.equals(body));
    }
}