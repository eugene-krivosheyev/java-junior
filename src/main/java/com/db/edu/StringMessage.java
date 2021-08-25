package com.db.edu;

public class StringMessage {
    private String messageBody;

    static String stringAcc = "";
    static int stringCount = 0;

    public StringMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    static void printAccumulatedString() {
        if (stringCount != 0) {
            ConsoleSaver.printToConsole(Prefix.STRING.value + stringAcc + (stringCount > 1 ? " (x" + stringCount + ")" : ""));
            stringCount = 0;
            stringAcc = "";
        }
    }

    public static void accumulate(StringMessage message) {
        if (stringCount > 0 && !stringAcc.equals(message.messageBody)) {
            StringMessage.printAccumulatedString();
        }
        stringAcc = message.messageBody;
        stringCount++;
    }

    @Override
    public String toString() {
        return Prefix.STRING.value + messageBody;
    }
}
