package com.acme.edu.model.message;

public class BooleanMessageWithStringValue extends UnableToJoinMessageWithStringValue {
    public BooleanMessageWithStringValue(String value) {
        super(value);
    }


    @Override
    public String toString() {
        return "primitive: " + getStringValue();
    }

}
