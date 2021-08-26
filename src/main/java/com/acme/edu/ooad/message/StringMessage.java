package com.acme.edu.ooad.message;

public class StringMessage extends AccumulatedMessage {

    private static String lastString;
    private static int repeatableStringCounter;

    private final String currentString;

    public StringMessage(String value) {
        super("string: ");
        this.currentString = value;
    }

    public boolean isNeedToFlush(){
        return repeatableStringCounter != 0 && !currentString.equals(lastString);
    }

    @Override
    public String toString() {
        return getPrefix() + lastString + (repeatableStringCounter > 1 ? " (x" + repeatableStringCounter + ")" : "");
    }

    public void process() {
        lastString = currentString;
        ++repeatableStringCounter;
    }

    public void clean() {
        repeatableStringCounter = 0;
    }
}
