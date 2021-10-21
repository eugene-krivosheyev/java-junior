package com.acme.edu.api.message;

import com.acme.edu.Logger;
import com.acme.edu.api.LoggerController;
import com.acme.edu.api.saver.Saver;

import java.io.ObjectStreamException;
import java.util.Objects;

public class StringMessage extends SummableStringMessage {
    private static int currentStringCounter = 1;
    private static String accumString;
    private String current;

    public StringMessage(String nameString) {
        setPrefix("string: ");
        this.setNameString(nameString);
        //setValue(value);
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public Message accumulate(Message message) {
        StringMessage stringMessage = (StringMessage) message;
        if (previousStringCheck(stringMessage)) {
            currentStringCounter++;
        } else {
            stringMessage = getMessage();
            currentStringCounter = 1;
        }

        if (stringMessage.getValue().equals(getValue())) {

        }
        return message;
    }

    private boolean previousStringCheck(StringMessage message) {
        return (this.getNameString().equals(message.getNameString()));
    }

    private StringMessage getMessage() {
        if (currentStringCounter == 1) {
            return new StringMessage();
        } else {
            return new StringMessage(lastSubmittedString + " (x" + sameLastStringCounter + ")");
        }
    }
}