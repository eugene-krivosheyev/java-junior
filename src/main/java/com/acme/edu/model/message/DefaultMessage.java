package com.acme.edu.model.message;

import com.acme.edu.model.MessageType;

public class DefaultMessage extends Message {

    public DefaultMessage(MessageType type, String value) {
        super(type, value);
    }

    @Override
    public void addValue(String value) {

    }

}
