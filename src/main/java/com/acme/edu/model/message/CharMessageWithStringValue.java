package com.acme.edu.model.message;

public class CharMessageWithStringValue extends UnableToJoinMessageWithStringValue {
    public CharMessageWithStringValue(String value) {
        super(value);
    }


    @Override
    public String toString() {
        return "char: " + getStringValue();
    }

}
