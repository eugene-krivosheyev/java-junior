package com.acme.edu.message;

import com.acme.edu.Prefix;

public class ReferenceMessage extends Message {

    public ReferenceMessage(Object body) {
        super(body);
    }

    public boolean sameTypeOf(Message message) {
        return false;
    }

    public Message accumulate(Message message) {
        return this;
    }

    public String getDecoratedMessage() {
        return String.format("%s %s%n", Prefix.REFERENCE.value, super.getBody().toString());
    }
}
