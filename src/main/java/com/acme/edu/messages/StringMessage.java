package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class StringMessage implements Message {
    private String value;
    private int counter;

    public StringMessage(String value) {
        this.value = value;
        counter = 1;
    }

    @Override
    public boolean equals(Object message) {
        if (!(message instanceof StringMessage))
        {
            return false;
        }
        StringMessage stringMessage = (StringMessage) message;
        return (value.equals(stringMessage.value) && (counter == stringMessage.counter));
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
    public boolean isSameType(Message message) {
        return (message instanceof StringMessage);
    }

    @Override
    public Message accumulate(Message message) {
        if (!(message instanceof StringMessage)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of StringMessage");
        }
        StringMessage stringMessage = (StringMessage) message;
        StringMessage newMessage = null;
        if (value.equals(stringMessage.value)) {
            counter++;
        } else {
            newMessage = new StringMessage(stringMessage.value);
        }
        return newMessage;
    }
}
