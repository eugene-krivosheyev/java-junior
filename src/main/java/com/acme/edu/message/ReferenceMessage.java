package com.acme.edu.message;

import com.acme.edu.Prefix;

public class ReferenceMessage extends Message {

    public ReferenceMessage(Object body) {
        super(body);
    }

    public String getDecoratedMessage() {
        return getDefaultDecoratedMessage(Prefix.REFERENCE);
    }
}
