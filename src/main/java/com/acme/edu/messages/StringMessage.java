package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class StringMessage implements Message {
    private String value;
    private int counter;

    public StringMessage(String value) {
        this(value, 1);
    }
    public StringMessage(String value, int counter) {
        this.value = value;
        this.counter = counter;
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
            return message;
        }
        return newMessage;
    }
}
