package com.acme.edu.api.message;

public class StringMessage extends Message {
    private int currentStringCounter = 1;
    private final String current;

    public StringMessage(String nameString) {
        current = nameString;
        setPrefix("string: ");
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public Message accumulate(Message message) {
        StringMessage stringMessage = (StringMessage) message;
        StringMessage newMessage = new StringMessage(stringMessage.current);
        if (previousStringCheck(stringMessage)) {
            newMessage.setCounter(currentStringCounter + 1);
            newMessage.setValue(this.getValue());
        } else {
            newMessage.setValue((this.getValue() == null ? "" : this.getValue()) + getSingleString());
        }
        return newMessage;
    }

    private void setCounter(int value) {
        currentStringCounter = value;
    }

    private boolean previousStringCheck(StringMessage message) {
        return message.current.equals(this.current);
    }

    @Override
    public String getMessageAsString() {
        return (getValue() == null ? "" : getValue()) + System.lineSeparator() + getSingleString();
    }

    private String getSingleString() {
        if (currentStringCounter == 1) {
            return "string: " + current;
        } else {
            return "string: " + current + " (x" + currentStringCounter + ")";
        }
    }
}