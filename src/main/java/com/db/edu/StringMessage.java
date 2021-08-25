package com.db.edu;

public class StringMessage {
    private String messageBody;
    int stringCount = 0;

    public StringMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    void printAccumulatedString() {
        if (stringCount != 0) {
            ConsoleSaver.printToConsole(this.toString());
            stringCount = 0;
            messageBody = "";
        }
    }

    public void accumulate(StringMessage message) {
        if (stringCount > 0 && !messageBody.equals(message.messageBody)) {
            this.printAccumulatedString();
        }
        messageBody = message.messageBody;
        stringCount++;
    }

    @Override
    public String toString() {
        return Prefix.STRING.value + messageBody + (stringCount > 1 ? " (x" + stringCount + ")" : "");
    }
}
