package com.acme.edu.api.message;

public abstract class SummableStringMessage extends Message {
    protected int currentStringCounter = 1;
    protected final String currentString;

    public SummableStringMessage(String currentString) {
        if (currentString == null) throw new IllegalArgumentException("You try to write a Null String");
        setPrefix("string: ");
        this.currentString = currentString;
    }

    public String getCurrentString() {
        return currentString;
    }

    public int getCurrentStringCounter() {
        return currentStringCounter;
    }

    public void setCurrentStringCounter(int currentStringCounter) {
        this.currentStringCounter = currentStringCounter;
    }

    protected String makeStringWithRepeat() {
        return (this.getPrefix() + this.getValue() + getString());
    }

    protected String getString() {
        if (this.getCurrentStringCounter() == 1) {
            return (this.getCurrentString());
        } else {
            return (this.getCurrentString() + " (x" + this.getCurrentStringCounter() + ")");
        }
    }

}
