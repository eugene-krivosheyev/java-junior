package com.acme.edu.message;

public class EmptyMessage extends Message {

    public EmptyMessage() {
        super(null);
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}
