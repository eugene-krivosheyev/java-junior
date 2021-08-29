package com.acme.edu.message;

import com.acme.edu.Prefix;

public class CharMessage extends Message {
    public CharMessage(char body) {
        super(body);
    }

    @Override
    public String getDecoratedMessage() {
        return getDefaultDecoratedMessage(Prefix.CHAR);
    }
}
