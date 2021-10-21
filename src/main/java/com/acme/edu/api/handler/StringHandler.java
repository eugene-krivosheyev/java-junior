package com.acme.edu.api.handler;

import com.acme.edu.api.message.StringMessage;

import java.util.Objects;

public class StringHandler {
    private String lastSubmittedString;
    private int sameLastStringCounter = 1;

    public boolean isEqualToLast(String message) {
        if (Objects.equals(message, lastSubmittedString)) {
            sameLastStringCounter++;
        }

        return Objects.equals(message, lastSubmittedString);
    }

    public void setLastSubmittedString(String message) {
        lastSubmittedString = message;
        sameLastStringCounter = 1;
    }

    public StringMessage getMessage() {
        if (sameLastStringCounter == 1) {
            return new StringMessage(lastSubmittedString);
        } else {
            return new StringMessage(lastSubmittedString + " (x" + sameLastStringCounter + ")");
        }
    }
}
