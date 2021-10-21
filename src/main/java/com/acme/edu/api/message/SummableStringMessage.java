package com.acme.edu.api.message;

public abstract class SummableStringMessage extends Message {
    private String nameString;

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }
}
