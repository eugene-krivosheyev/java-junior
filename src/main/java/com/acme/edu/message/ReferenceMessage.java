package com.acme.edu.message;

public class ReferenceMessage extends Message {

    private static final String REFERENCE_PREFIX = "reference: ";

    public ReferenceMessage() {
        super(Type.REFERENCE);
    }
}
