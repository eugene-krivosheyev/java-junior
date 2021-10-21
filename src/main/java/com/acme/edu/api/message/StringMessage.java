package com.acme.edu.api.message;

public class StringMessage extends StringMessageAccumulate {

    public StringMessage(String currentString) {
        super(currentString);
    }

    @Override
    public String getMessageAsString() {
        checkTheStartOfTheQuery();
        return this.getValue() + getString();
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public Message accumulate(Message message) {
        StringMessage stringMessage = (StringMessage) message;
        StringMessage currentMessage = new StringMessage(stringMessage.getCurrentString());
        checkTheStartOfTheQuery();
        if (!previousStringCheck(stringMessage)) {
            currentMessage.setValue(makeStringWithRepeat());
        } else {
            currentMessage.setCurrentStringCounter(getCurrentStringCounter() + 1);
            currentMessage.setValue(this.getValue());
        }
        return currentMessage;
    }

    private boolean previousStringCheck(StringMessage message) {
        return (this.currentString.equals(message.getCurrentString()));
    }

    private void checkTheStartOfTheQuery() {
        if (this.getValue() == null) {
            this.setValue("");
        }
    }
}