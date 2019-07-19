package com.acme.edu;

import static java.lang.System.lineSeparator;

public class ControllerState {
    private int accumulatedSum;
    private String accumulatedString;
    private String previousString;
    private int stringCounter;
    private MessageTypeName previousState = MessageTypeName.INITIAL;

    public int getAccumulatedSum() {
        return accumulatedSum;
    }

    public String getAccumulatedString() {
        return accumulatedString;
    }

    public String getPreviousString() {
        return previousString;
    }

    public int getStringCounter() {
        return stringCounter;
    }

    public MessageTypeName getPreviousState() {
        return previousState;
    }

    public void setAccumulatedSum(int accumulatedSum) {

        this.accumulatedSum = accumulatedSum;
    }

    public void setAccumulatedString(String accumulatedString) {
        this.accumulatedString += accumulatedString + lineSeparator();
    }

    public void setPreviousString(String previousString) {
        this.previousString = previousString;
    }

    public void setStringCounter(int stringCounter) {
        this.stringCounter = stringCounter;
    }


    public ControllerState() {
        accumulatedString = "";
        accumulatedSum = 0;
        previousString = "";
        stringCounter = 0;
    }

}
