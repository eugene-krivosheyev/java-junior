package com.acme.edu.expressionproblem.message;

import com.acme.edu.expressionproblem.format.FormatVisitor;

public class IntMessage implements Message {
    private int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return Integer.toString(body);
    }

    @Override
    public String accept(FormatVisitor formatVisitor) {
        return formatVisitor.formatIntMessage(this);
    }

    @Override
    public void setValue(int i) {

    }
}
