package com.acme.edu.message;

public class StringMessage extends Message {
    private static final String TYPE_NAME = "string";
    private String value;
    private int currentStringCount;

    private StringMessage(String message, int count) {
        this.value = message;
        type = TYPE_NAME;
        currentStringCount = count;
    }

    public StringMessage(String message){
        this(message, 1);
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(value, currentStringCount + 1);
    }

    @Override
    public String getFormattedMessage(){
        String postfixForRepeatedStrings = (currentStringCount > 1) ? String.format(" (x%d)", currentStringCount) : "";
        return super.getFormattedString(value) + postfixForRepeatedStrings;
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message) && ((StringMessage) message).value.equals(value);
    }
}
