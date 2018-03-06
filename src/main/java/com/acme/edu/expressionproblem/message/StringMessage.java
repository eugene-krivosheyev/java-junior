package com.acme.edu.expressionproblem.message;

import com.acme.edu.expressionproblem.format.FormatVisitor;

public class StringMessage implements Message {
    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatStringMessage(this);
    }
}
