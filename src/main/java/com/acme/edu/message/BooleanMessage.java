package com.acme.edu.message;

import com.acme.edu.Prefix;

public class BooleanMessage extends Message{

    public BooleanMessage(boolean body) {
        super(body);
    }

    @Override
    public String getDecoratedMessage(){
        return getDefaultDecoratedMessage(Prefix.PRIMITIVE);
    }
}
