package com.acme.edu.functional;

import com.acme.edu.expressionproblem.format.FormatVisitor;

public class ByteMessage implements com.acme.edu.expressionproblem.message.Message {
    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }


    @Override
    public String accept(FormatVisitor formatVisitor) {
        return null;
    }

    @Override
    public void setValue(int i) {

    }
}
